package com.example.diahshintadewi.roommatefinal;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText name, phone;
    private AppCompatTextView save, delete, email;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference;
    private String idUser, emailUser;
    ProgressDialog dialog;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        name = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        phone = (TextInputEditText) findViewById(R.id.textInputEditTextPhone);
        email = (AppCompatTextView) findViewById(R.id.email);
        delete = (AppCompatTextView) findViewById(R.id.appCompatDeleteAccount);
        save = (AppCompatTextView) findViewById(R.id.appCompatSave);

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = auth.getCurrentUser();
        idUser = user.getUid();
        emailUser = user.getEmail();
        dialog = new ProgressDialog(this);
        loadData();

        email.setText(emailUser);

        save.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == save){
            saveData();
            finish();
        }
        if (view == delete){
            delete();
            finish();
        }
    }

    private void delete() {
        FirebaseUser usr = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            dialog.setMessage("Delete Account?");
            dialog.show();
            usr.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Account deleted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Account could not be deleted", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void loadData() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("user").child(idUser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user != null) {
                    name.setText(user.getName());
                    phone.setText(user.getPhone());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void saveData() {
        String nama = name.getText().toString().trim();
        String telp = phone.getText().toString().trim();

        if (nama.isEmpty()){
            name.setError("*Required");
        }
        if (telp.isEmpty()){
            phone.setError("*Required");
        }

        databaseReference.child("User").child(idUser).child("Name").setValue(nama);
        databaseReference.child("User").child(idUser).child("Phone").setValue(telp);
        Toast.makeText(EditProfileActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

    }
}

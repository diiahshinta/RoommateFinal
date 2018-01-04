package com.example.diahshintadewi.roommatefinal;

import java.io.Serializable;

/**
 * Created by Diah Shinta Dewi on 12/29/2017.
 */

public class User implements Serializable {
    private String Name, Phone;

    public User() {

    }

    public User(String Name, String Phone) {
        this.Name = Name;
        this.Phone = Phone;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }
}

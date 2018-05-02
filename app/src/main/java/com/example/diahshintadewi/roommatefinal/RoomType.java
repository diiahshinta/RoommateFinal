package com.example.diahshintadewi.roommatefinal;

import java.util.ArrayList;

/**
 * Created by Diah Shinta Dewi on 4/9/2018.
 */

public class RoomType {
    String nama, harga;
    ArrayList<Fasilitas> fasilitasList;
    public RoomType(){}
    public RoomType(String nama, String harga, ArrayList<Fasilitas> fasilitasList){
        this.nama = nama;
        this.harga = harga;
        this.fasilitasList = fasilitasList;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public ArrayList<Fasilitas> getFasilitasList() {
        return fasilitasList;
    }

    public void setFasilitasList(ArrayList<Fasilitas> fasilitasList) {
        this.fasilitasList = fasilitasList;
    }
}

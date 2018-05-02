package com.example.diahshintadewi.roommatefinal.listPage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Diah Shinta Dewi on 1/6/2018.
 */

public class HostelData implements Serializable {
    private String alamatHostel, gambar, harga, komentar, namaHostel,  ratingHostel, telp2, telpHostel, website;
    ArrayList<String> fasilitasHostel;
    //RoomType roomType;


    public HostelData(String alamatHostel,  ArrayList<String> fasilitasHostel, String gambar, String harga, String komentar, String namaHostel, String ratingHostel, String telp2,  String telpHostel, String website) {
        this.alamatHostel = alamatHostel;
        //this.roomType = roomType;
        this.fasilitasHostel = fasilitasHostel;
        this.gambar = gambar;
        //this.gambar360 = gambar360;
        this.harga = harga;
        this.komentar = komentar;
        this.namaHostel = namaHostel;
        this.ratingHostel = ratingHostel;
        this.telp2 = telp2;
        this.telpHostel = telpHostel;
        this.website = website;
    }



//    public ArrayList<String> getGambar360() {
//        return gambar360;
//    }
//
//    public void setGambar360(ArrayList<String> gambar360) {
//        this.gambar360 = gambar360;
//    }

    public String getTelp2() {
        return telp2;
    }

    public void setTelp2(String telp2) {
        this.telp2 = telp2;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTelpHostel() {
        return telpHostel;
    }

    public void setTelpHostel(String telpHostel) {
        this.telpHostel = telpHostel;
    }

    public String getRatingHostel() {
        return ratingHostel;
    }

    public void setRatingHostel(String ratingHostel) {
        this.ratingHostel = ratingHostel;
    }

    public String getAlamatHostel() {
        return alamatHostel;
    }

    public void setAlamatHostel(String alamatHostel) {
        this.alamatHostel = alamatHostel;
    }

    public ArrayList<String> getFasilitasHostel() {
        return fasilitasHostel;
    }

    public void setFasilitasHostel(ArrayList<String> fasilitasHostel) {
        this.fasilitasHostel = fasilitasHostel;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getNamaHostel() {
        return namaHostel;
    }

    public void setNamaHostel(String namaHostel) {
        this.namaHostel = namaHostel;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
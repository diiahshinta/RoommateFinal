package com.example.diahshintadewi.roommatefinal;

import java.io.Serializable;

/**
 * Created by Diah Shinta Dewi on 4/16/2018.
 */

public class Wishlist implements Serializable{
    private String namaHostel, alamatHostel, telponHostel;
    public Wishlist(){}

    public Wishlist(String namaHostel, String alamatHostel, String teleponHostel){
        this.namaHostel = namaHostel;
        this.alamatHostel = alamatHostel;
        this.telponHostel = telponHostel;
    }

    public String getNamaHostel() {
        return namaHostel;
    }

    public void setNamaHostel(String namaHostel) {
        this.namaHostel = namaHostel;
    }

    public String getAlamatHostel() {
        return alamatHostel;
    }

    public void setAlamatHostel(String alamatHostel) {
        this.alamatHostel = alamatHostel;
    }

    public String getTelponHostel() {
        return telponHostel;
    }

    public void setTelponHostel(String telponHostel) {
        this.telponHostel = telponHostel;
    }
}

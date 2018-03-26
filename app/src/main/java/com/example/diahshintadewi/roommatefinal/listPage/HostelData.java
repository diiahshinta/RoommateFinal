package com.example.diahshintadewi.roommatefinal.listPage;

import java.io.Serializable;

/**
 * Created by Diah Shinta Dewi on 1/6/2018.
 */

public class HostelData implements Serializable {
    private String alamatHostel, fasilitasHostel, gambar, harga, komentar, namaHostel,  ratingHostel, tipeKamar, telp2, telpHostel, website;

    public HostelData() {

    }

    public HostelData(String alamatHostel, String fasilitasHostel, String gambar, String harga, String komentar, String namaHostel, String ratingHostel, String tipeKamar, String telp2,  String telpHostel, String website) {
        this.alamatHostel = alamatHostel;
        this.fasilitasHostel = fasilitasHostel;
        this.gambar = gambar;
        this.harga = harga;
        this.komentar = komentar;
        this.namaHostel = namaHostel;
        this.ratingHostel = ratingHostel;
        this.tipeKamar = tipeKamar;
        this.telp2 = telp2;
        this.telpHostel = telpHostel;
        this.website = website;
    }

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

    public String getFasilitasHostel() {
        return fasilitasHostel;
    }

    public void setFasilitasHostel(String fasilitasHostel) {
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

    public String getTipeKamar() {
        return tipeKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
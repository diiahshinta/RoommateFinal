package com.example.diahshintadewi.roommatefinal;

import java.util.ArrayList;

/**
 * Created by Diah Shinta Dewi on 4/9/2018.
 */

public class Fasilitas {
    private ArrayList<String> fasilitasKamar;
    public Fasilitas(){}
    public Fasilitas(ArrayList<String> fasilitasKamar){
        this.fasilitasKamar = fasilitasKamar;
    }

    public ArrayList<String> getFasilitasKamar() {
        return fasilitasKamar;
    }

    public void setFasilitasKamar(ArrayList<String> fasilitasKamar) {
        this.fasilitasKamar = fasilitasKamar;
    }
}

package com.example.diahshintadewi.roommatefinal;

import java.io.Serializable;

/**
 * Created by Diah Shinta Dewi on 1/8/2018.
 */

public class VenueData implements Serializable {
    private String namaVenue, ratingVenue;
    public VenueData(){}
    public VenueData(String namaVenue, String ratingVenue){
        this.namaVenue = namaVenue;
        this.ratingVenue = ratingVenue;
    }

    public String getNamaVenue() {
        return namaVenue;
    }

    public void setNamaVenue(String namaVenue) {
        this.namaVenue = namaVenue;
    }

    public String getRatingVenue() {
        return ratingVenue;
    }

    public void setRatingVenue(String ratingVenue) {
        this.ratingVenue = ratingVenue;
    }
}

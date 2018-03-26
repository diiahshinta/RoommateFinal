package com.example.diahshintadewi.roommatefinal;

import java.io.Serializable;

/**
 * Created by Diah Shinta Dewi on 1/8/2018.
 */

public class VenueData implements Serializable {
    private String venueName, venueRating, venueAddress;
    public VenueData(){}
    public VenueData(String venueName, String venueRating, String venueAddress){
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.venueRating = venueRating;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueRating() {
        return venueRating;
    }

    public void setVenueRating(String venueRating) {
        this.venueRating = venueRating;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }
}

package com.example.diahshintadewi.roommatefinal;

import java.io.Serializable;

/**
 * Created by Diah Shinta Dewi on 1/6/2018.
 */

public class RoomType implements Serializable {
    private String imageUrl;

    public void String (String imageUrl){
        this.imageUrl = imageUrl;
    }

    public RoomType() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}


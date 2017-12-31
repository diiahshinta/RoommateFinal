package com.example.diahshintadewi.roommatefinal;

import java.io.Serializable;

/**
 * Created by Diah Shinta Dewi on 12/29/2017.
 */

public class User  implements Serializable {
    private String name, phone;
    public User(){

    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

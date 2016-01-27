package com.epam.java.courses.fundamentals.dto;

/**
 * Created by maria on 27.01.16.
 */
public class Resort {

    @NotNull
    private int resort_id;

    @Size(30)
    private String name;

    @Size(20)
    private String country;

    @Size(20)
    private String location;

    public int getId(){
        return resort_id;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public String getLocation(){
        return location;
    }

    //todo change delete

}

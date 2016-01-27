package com.epam.java.courses.fundamentals.dto;

/**
 * Created by maria on 27.01.16.
 */
public class Type {

    @NotNull
    private int type_id;

    @NotNull
    @Size(20)
    private String name;

    public int getId(){
        return type_id;
    }

    public String getName() {
        return name;
    }

    //todo change delete
}

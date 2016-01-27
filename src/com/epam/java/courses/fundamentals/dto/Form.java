package com.epam.java.courses.fundamentals.dto;

import java.sql.Timestamp;

/**
 * Created by maria on 27.01.16.
 */
public class Form {

    @NotNull
    private int form_id;

    @NotNull
    private int client_id;

    @NotNull
    private int tour_id;

    private Timestamp date;

    private int discount;


    public int getId() {
        return form_id;
    }

    public int getClientId() {
        return client_id;
    }

    public int getTourId() {
        return tour_id;
    }

    //todo change delete
}

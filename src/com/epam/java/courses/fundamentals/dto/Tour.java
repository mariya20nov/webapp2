package com.epam.java.courses.fundamentals.dto;

import java.sql.Timestamp;

/**
 * Created by maria on 27.01.16.
 */
public class Tour {

    @NotNull
    private int tour_id;

    @Size(50)
    private String name;

    private int resort_id;

    private int type_id;

    private Timestamp date_beg;

    private Timestamp date_end;

    @NotNull
    private int cost;


    public int getId() {
        return tour_id;
    }

    public String getName() {
        return name;
    }

    public int getResortId() {
        return resort_id;
    }

    public int getTourId() {
        return tour_id;
    }

    public Timestamp getDateBeg() {
        return date_beg;
    }

    public Timestamp getDateEnd() {
        return date_end;
    }

    public int getCost() {
        return cost;
    }

    //todo change delete
}

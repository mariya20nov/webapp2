package com.epam.java.courses.fundamentals.dto;

public class Client {

    @NotNull
    private int client_id;

    @Size(30)
    private String name;

    @Size(30)
    private String surname;

    @Size(30)
    private String middle_name;

    @Size(10)
    private String passport;

    private int tour_count;


    public int getId() {
        return client_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public String getPassport() {
        return passport;
    }

    public int getTourCount() {
        return tour_count;
    }

    //todo change delete
}

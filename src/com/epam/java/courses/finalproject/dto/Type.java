package com.epam.java.courses.finalproject.dto;

/**
 * Class for connecting to database table Type
 */
public class Type {

    @NotNull
    private int type_id;

    @NotNull
    @Size(20)
    /**
     * name: "Шоппинг", "Экскурсия" or "Отдых"
     */
    private String name;

    public Type() {
    }

    public int getId(){
        return type_id;
    }

    public String getName() {
        return name;
    }

    //todo change delete
}

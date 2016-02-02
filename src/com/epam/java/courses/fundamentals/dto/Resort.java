package com.epam.java.courses.fundamentals.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

    public static void addResort(Connection con, String name, String country, String location) {
        String sql = "INSERT INTO Resort(name, country, location) VALUES(?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, country);
            ps.setString(3, location);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteResort(Connection con, int resort_id) {
        String sql = "DELETE FROM Resort WHERE resort_id=?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, resort_id);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}

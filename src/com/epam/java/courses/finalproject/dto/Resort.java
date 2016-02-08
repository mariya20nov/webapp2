package com.epam.java.courses.finalproject.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Class for connecting to database table Resort
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

    /**
     *  Method for adding a new resort
     * @param con connection to DB
     * @param name name of the resort
     * @param country
     * @param location city/town/country
     */
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

    /**
     * Method for deleting resort
     * @param con connection to DB
     * @param resort_id ID of resort you want to delete
     */
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

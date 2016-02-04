package com.epam.java.courses.fundamentals.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public int getTypeId() {
        return type_id;
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

    public static void addTour(Connection con, int resort_id, int type_id, String name,
                               Timestamp date_beg, Timestamp date_end, int cost) {
        String sql = "INSERT INTO Tour(resort_id, type_id, name, date_beg, date_end, cost) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, resort_id);
            ps.setInt(2, type_id);
            ps.setString(3, name);
            ps.setTimestamp(4, date_beg);
            ps.setTimestamp(5, date_end);
            ps.setInt(6, cost);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteTour(Connection con, int tour_id) {
        String sql = "DELETE FROM Tour WHERE tour_id=?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tour_id);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void markAsHot(Connection con, int tour_id) {
        String sql = "UPDATE Tour SET hot=TRUE WHERE tour_id=?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, tour_id);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void changeTour(Connection con, int tour_id, int cost) {
        int i = 0;

        //todo проверка id int cost

        String sql = "UPDATE Tour SET cost=? WHERE tour_id=?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cost);
            ps.setInt(2, tour_id);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

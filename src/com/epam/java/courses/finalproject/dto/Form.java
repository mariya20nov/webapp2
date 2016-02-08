package com.epam.java.courses.finalproject.dto;

import com.epam.java.courses.finalproject.Logger4j;

import java.sql.*;

/**
 * Class for connecting to database table Form
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

    public Timestamp getDate(){
        return date;
    }

    public int getDiscount(){
        return discount;
    }

    /**
     * Method for adding new form
     * @param con connection to DB
     * @param client_id
     * @param tour_id
     */
    public static void addForm(Connection con, int client_id, int tour_id) {
        String sql = "SELECT * FROM Client WHERE client_id='" + client_id + "'";
        int tourCount = 0;
        int discount = 0;

        try(Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            //todo
            while (rs.next()) {
                tourCount = rs.getInt("tour_count");
            }
            if (tourCount >= 5){
                discount = 5; //%
            }

            java.util.Date date= new java.util.Date();

            sql = "INSERT INTO Form(client_id, tour_id, date, discount) VALUES(?,?,?,?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, client_id);
                ps.setInt(2, tour_id);
                ps.setTimestamp(3, new Timestamp(date.getTime()));
                ps.setInt(4, discount);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Client.addTourCount(con, client_id, 1);
        }catch (SQLException e) {
            Logger4j.log.error("Create statement exception ", e);
        }

    }

    /**
     * Method for deleting form
     * @param con connection to DB
     * @param form_id
     */
    public static void deleteForm(Connection con, int form_id) {
        String sql = "DELETE FROM Form WHERE form_id=?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int client_id = 0;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Form WHERE form_id=" + form_id);
            while (rs.next()) {
                client_id = rs.getInt("client_id");
            }
            Client.addTourCount(con, client_id, -1);

            ps.setInt(1, form_id);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

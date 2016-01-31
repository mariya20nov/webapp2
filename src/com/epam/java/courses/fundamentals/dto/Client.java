package com.epam.java.courses.fundamentals.dto;

import java.sql.*;

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

    public Client() {}

    public Client(String name, String middle_name, String surname, String passport) {
        this.name = name;
        this.surname = surname;
        this.middle_name = middle_name;
        this.passport = passport;
        this.tour_count = 0;
    }

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

    public void setId(int id) {
        this.client_id = id;//todo check duplicates
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setTourCount(int tour_count) {
        this.tour_count = tour_count;
    }

    public static void addClient(Connection con, String name, String middle_name, String surname, String passport) {
        String sql = "INSERT INTO Client(name, middle_name, surname, passport, tour_count) VALUES(?,?,?,?,?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, middle_name);
                ps.setString(3, surname);
                ps.setString(4, passport);
                ps.setInt(5, 0);
                ps.executeUpdate();
            } catch (Exception e){
                e.printStackTrace();
            }

    }

    public static void deleteClient(Connection con, int client_id) {
        String sql = "DELETE FROM Client WHERE client_id=?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, client_id);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void changeClient(Connection con, int client_id, String name, String middle_name, String surname, String passport) {
        int i = 0;

        //todo проверка id int

        String sql = "UPDATE Client SET ";

        if (!name.equals("")) {
            sql += " name=?";
            i++;
        }
        if (!middle_name.equals("")) {
            if(i!=0) sql += ",";
            sql += " middle_name=?";
            i++;
        }
        if (!surname.equals("")) {
            if(i!=0) sql += ",";
            sql += " surname=?";
            i++;
        }
       if (!passport.equals("")) {
            if(i!=0) sql += ",";
            sql += " passport=?";
            i++;
        }
        sql += " WHERE client_id=?;";// + client_id + ";";
        System.out.println(sql);

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int k = 1;
            if (!name.equals("")) {
                ps.setString(k, name);
                k++;
            }
            if (!middle_name.equals("")) {
                ps.setString(k, middle_name);
                k++;
            }
            if (!surname.equals("")) {
                ps.setString(k, surname);
                k++;
            }
           if (!passport.equals("")) {
                ps.setString(k, passport);
                k++;
            }
            ps.setInt(k, client_id);
            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void addTourCount(Connection con, int client_id, int number) {
        //todo проверка id int
        int tourCount;

        String sql = "SELECT * FROM Client where client_id=" + client_id + ";";

        try( Statement statement = con.createStatement()){

            //todo нашел ли и одно ли
            ResultSet set = statement.executeQuery(sql);
            set.next();
            {
                //System.out.println("tour count: " + set.getInt("tour_count"));
                tourCount = set.getInt("tour_count") + number;
            }

                sql = "UPDATE Client SET tour_count=? WHERE client_id=?;";
                System.out.println(sql);

                try (PreparedStatement ps = con.prepareStatement(sql))  {
                    ps.setInt(1, tourCount);
                    ps.setInt(2, client_id);
                    ps.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }catch(SQLException e) {
                    e.printStackTrace();
        }

    }



    //todo change delete
}

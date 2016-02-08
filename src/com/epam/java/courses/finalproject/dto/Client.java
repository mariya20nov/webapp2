package com.epam.java.courses.finalproject.dto;

import com.epam.java.courses.finalproject.Logger4j;
import com.epam.java.courses.finalproject.Utils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Collection;

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

    public static void addClient(Connection con, String name, String middle_name, String surname, String passport, String password) {
        Logger4j.log = Logger.getLogger(Client.class.getName());

        String sql = "INSERT INTO Client(name, middle_name, surname, passport, tour_count, pwd) VALUES(?,?,?,?,?,?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, middle_name);
                ps.setString(3, surname);
                ps.setString(4, passport);
                ps.setInt(5, 0);
                ps.setString(6, password);
                ps.executeUpdate();
            } catch (Exception e){
                Logger4j.log.error("Exception in Prepared statement block. ", e);
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
        sql += " WHERE client_id=?;";
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
        int tourCount;

        String sql = "SELECT * FROM Client where client_id=" + client_id + ";";

        try( Statement statement = con.createStatement()){

            //todo нашел ли и одно ли
            ResultSet set = statement.executeQuery(sql);
            set.next();
            {
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

    public static Collection<Client> findClient(Connection con, String surname) {

        String sql = "SELECT * FROM Client where surname='" + surname + "';";

        try( Statement statement = con.createStatement()){

            //todo нашел ли
            ResultSet set = statement.executeQuery(sql);
            Collection<Client> clients = Utils.getEntities(set, Client.class);
            return clients;

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null; //todo ?
    }

    public static Collection<Client> sortClients(Connection con, String sortBy) {

        String sql = "SELECT * FROM Client ORDER BY " + sortBy + ";";

        try( Statement statement = con.createStatement()){

            //todo нашел ли
            ResultSet set = statement.executeQuery(sql);
            Collection<Client> clients = Utils.getEntities(set, Client.class);
            return clients;

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null; //todo ?
    }



    //todo change delete
}

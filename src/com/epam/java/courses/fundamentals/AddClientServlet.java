package com.epam.java.courses.fundamentals;


import com.epam.java.courses.fundamentals.dto.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/addclient")
public class AddClientServlet extends HttpServlet {
    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8";
        String usr = "root";
        String password = "mkpwd";

        req.setCharacterEncoding("UTF-8");

        Client client = new Client(req.getParameter("clientname"), req.getParameter("clientmiddlename"),
                req.getParameter("clientsurname"), req.getParameter("clientpassport"));
        System.out.println("client surname:" + client.getSurname());

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, password);

            Client.addClient(con, client.getName(), client.getMiddleName(), client.getSurname(), client.getPassport());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/clients");
            requestDispatcher.forward(req, resp);

        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found.");//todo
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception");//todo
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
}}

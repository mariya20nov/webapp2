package com.epam.java.courses.fundamentals;


import com.epam.java.courses.fundamentals.dto.Client;
import com.epam.java.courses.fundamentals.dto.Tour;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/changetour")
public class ChangeTourServlet extends HttpServlet {
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

        Logger4j.log = Logger.getLogger(ChangeClientServlet.class.getName());

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, password);

            //todo проверка Integer.parseInt(req.getParameter("clientid"))
            //System.out.println(req.getParameter(""));
            Tour.changeTour(con, new Integer(req.getParameter("tourid")), new Integer(req.getParameter("cost")));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tours");
            requestDispatcher.forward(req, resp);

        } catch (ClassNotFoundException e) {
            Logger4j.log.error("Class.forName(driver) is not found. ", e);
        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                Logger4j.log.error("Closing connection exception. ", e);
            }

        }
    }}


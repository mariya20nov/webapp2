package com.epam.java.courses.fundamentals;


import com.epam.java.courses.fundamentals.dto.Client;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/ordinaryclient")
public class FindTourForClientServlet extends HttpServlet {
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

        Logger4j.log = Logger.getLogger(FindTourForClientServlet.class.getName());

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, password);

            //todo убрать Tour.*

            if(!req.getParameter("country").isEmpty() && !req.getParameter("type").isEmpty()) {
                req.setAttribute("sqlstr", "SELECT Tour.* FROM Tour JOIN Type ON Tour.type_id=Type.type_id JOIN Resort ON Tour.resort_id=Resort.resort_id WHERE Resort.country='"
                + req.getParameter("country") + "' AND Type.name=" + "'" + req.getParameter("type") + "';");
            }
            else if(!req.getParameter("country").isEmpty()) {
                req.setAttribute("sqlstr", "SELECT Tour.* FROM (Tour JOIN Resort ON Tour.resort_id=Resort.resort_id) WHERE Resort.country="
                        + "'" + req.getParameter("country") + "';");
            }
            else if (!req.getParameter("type").isEmpty()) {
                req.setAttribute("sqlstr", "SELECT Tour.* FROM (Tour JOIN Type ON Tour.type_id=Type.type_id) WHERE Type.name="
                        + "'" + req.getParameter("type") + "';");
            }
            else {
                req.setAttribute("sqlstr", "SELECT * FROM Tour;");
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/ordinaryclient2.jsp");
            dispatcher.forward(req, resp);

        } catch (ClassNotFoundException e) {
            Logger4j.log.error("Class.forName(driver) is not found. ", e);
        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {;
                Logger4j.log.error("Closing connection exception. ", e);
            }

        }
    }}


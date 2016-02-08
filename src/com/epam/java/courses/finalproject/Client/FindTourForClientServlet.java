package com.epam.java.courses.finalproject.Client;


import com.epam.java.courses.finalproject.Logger4j;
import com.epam.java.courses.finalproject.TourOperator.TourOperatorServlet;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.sql.*;
import java.util.Properties;

/**
 * Class for looking for tours via ordinary client API
 */
@WebServlet("/ordinaryclient")
public class FindTourForClientServlet extends HttpServlet {
    Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Properties property = new Properties();
        try(InputStream fis = TourOperatorServlet.class.getClassLoader().getResourceAsStream("log4j.properties")) {
            property.load(fis);
        } catch (NoSuchFileException e) {
            System.err.println("Error: there is no properties-file!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Problems with properties-file");
            e.printStackTrace();
        }

        Logger4j.log = Logger.getLogger(FindTourForClientServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            String sqlstr = "";

            if(!req.getParameter("country").isEmpty() && !req.getParameter("type").isEmpty()) {
                sqlstr = "SELECT Tour.* FROM Tour JOIN Type ON Tour.type_id=Type.type_id JOIN Resort ON Tour.resort_id=Resort.resort_id WHERE Resort.country='"
                        + req.getParameter("country") + "' AND Type.name=" + "'" + req.getParameter("type") + "';";
            }
            else if(!req.getParameter("country").isEmpty()) {
                sqlstr = "SELECT Tour.* FROM (Tour JOIN Resort ON Tour.resort_id=Resort.resort_id) WHERE Resort.country="
                        + "'" + req.getParameter("country") + "';";
            }
            else if (!req.getParameter("type").isEmpty()) {
                sqlstr = "SELECT Tour.* FROM (Tour JOIN Type ON Tour.type_id=Type.type_id) WHERE Type.name="
                        + "'" + req.getParameter("type") + "';";
            }
            else {
                sqlstr = "SELECT * FROM Tour;";
            }

            req.getSession().setAttribute("sqlstr", sqlstr);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/client/ordinaryclient2.jsp");
            dispatcher.forward(req, resp);

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


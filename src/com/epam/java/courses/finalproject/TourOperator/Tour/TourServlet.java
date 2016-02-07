package com.epam.java.courses.finalproject.TourOperator.Tour;

import com.epam.java.courses.finalproject.Logger4j;
import com.epam.java.courses.finalproject.Utils;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

/**
 * Created by maria on 27.01.16.
 */
@WebServlet("/tours")
public class TourServlet extends HttpServlet {
    private static final String JDBC_TEST_DB = "jdbc/TravelAgency";

    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger4j.log = Logger.getLogger(TourServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/touroperator/tour/tours.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }

    }

    private Connection getConnection(HttpServletRequest req) {
        Connection connection = (Connection) req.getAttribute("connection");
        return (connection == null) ? getConnection(): connection;
    }

//    private Connection getConnection() {
//        return Pool.getInstance().getConnection();
//    }

    private Connection getConnection() {
        try {
            return Utils.localJndiSearch(JDBC_TEST_DB, DataSource.class).getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

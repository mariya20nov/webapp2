package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.dto.Client;
import com.epam.java.courses.fundamentals.dto.Resort;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.sql.*;
import java.util.Properties;

@WebServlet("/touroperator")
public class TourOperatorServlet extends HttpServlet {
    private static final String JDBC_TEST_DB = "jdbc/TravelAgency";

    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //загрузка проперти-файла для логера
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

        Logger4j.log = Logger.getLogger(TourOperatorServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/TourOperator.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }

    }


//todo что это?!
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

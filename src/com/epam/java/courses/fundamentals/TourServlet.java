package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.dto.Resort;
import com.epam.java.courses.fundamentals.dto.Tour;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Collection;

/**
 * Created by maria on 27.01.16.
 */
@WebServlet("/tours")
public class TourServlet extends HttpServlet {
    private static final String GET_ALL_TOURS = "SELECT * FROM Tour;";//todo
    private static final String JDBC_TEST_DB = "jdbc/TravelAgency";

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
        Statement statement;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, password);;

            statement = con.createStatement();
            //statement.execute("INSERT INTO Resort VALUES(null, 'AstoriaResort', 'Чехия', 'Карловы Вары');");

            /////////////
            ResultSet resultSet = statement.executeQuery(GET_ALL_TOURS);
            Collection<Tour> tours = Utils.getEntities(resultSet, Tour.class);
            req.setAttribute("tours", tours);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/tours.jsp");
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

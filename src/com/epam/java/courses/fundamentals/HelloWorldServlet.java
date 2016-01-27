package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.dto.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Collection;

@WebServlet("/main")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"tomcat"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"tomcat"}),
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"manager-gui"}),
        })
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


      //  RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/TourOperator.jsp");
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("/touroperator");
        requestDispatcher.forward(req, resp);
    }

   /* private Connection getConnection(HttpServletRequest req) {
        Connection connection = (Connection) req.getAttribute("connection");
        return (connection == null) ? getConnection(): connection;
    }

//    private Connection getConnection() { //todo
//        return Pool.getInstance().getConnection();
//    }

    private Connection getConnection() {
        try {
            return Utils.localJndiSearch(JDBC_TEST_DB, DataSource.class).getConnection(); //todo
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}

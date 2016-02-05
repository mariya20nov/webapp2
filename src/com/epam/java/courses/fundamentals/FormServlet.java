package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.Utils;
import com.epam.java.courses.fundamentals.dto.Form;
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
import java.util.Collection;

@WebServlet("/forms")
public class FormServlet extends HttpServlet {
    private static final String GET_ALL_FORMS = "SELECT * FROM Form;";//todo
    private static final String JDBC_TEST_DB = "jdbc/TravelAgency";

    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement statement;

        Logger4j.log = Logger.getLogger(FormServlet.class.getName());

            try {
                con = (Connection) req.getSession().getAttribute("con");

                statement = con.createStatement();
                //statement.execute("INSERT INTO Resort VALUES(null, 'AstoriaResort', 'Чехия', 'Карловы Вары');");

                /////////////
                ResultSet resultSet = statement.executeQuery(GET_ALL_FORMS);
                Collection<Form> forms = Utils.getEntities(resultSet, Form.class);
                req.setAttribute("forms", forms);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/forms.jsp");
                requestDispatcher.forward(req, resp);

               /* resultSet = statement.executeQuery(GET_ALL_CLIENTS);
                Collection<Client> clients = Utils.getEntities(resultSet, Client.class);
                req.setAttribute("clients", clients);

                requestDispatcher = req.getRequestDispatcher("/jsp/clients.jsp");
                requestDispatcher.forward(req, resp);
                ////////////////*/

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

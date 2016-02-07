package com.epam.java.courses.finalproject;

import com.epam.java.courses.finalproject.cp.Pool;
import com.epam.java.courses.finalproject.dto.Client;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.login("tomcat", "tomcat");

        Connection con = null;

            Logger4j.log = Logger.getLogger(AddUserServlet.class.getName());

            req.setCharacterEncoding("UTF-8");

            Client client = new Client(req.getParameter("clientname"), req.getParameter("clientmiddlename"),
                    req.getParameter("clientsurname"), req.getParameter("clientpassport"));
            System.out.println("Client surname:" + client.getSurname());

            try {
                con = getConnection(req);
                HttpSession se = req.getSession(true);
                se.setAttribute("con", con);

                Client.addClient(con, client.getName(), client.getMiddleName(), client.getSurname(),
                        client.getPassport(), req.getParameter("clientpassword")); //todo

                req.getSession().setAttribute("passport", "'"+client.getPassport()+"'");

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/signup2.jsp");
                requestDispatcher.forward(req, resp);

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
    }


    private Connection getConnection(HttpServletRequest req) {
        Connection connection = (Connection) req.getAttribute("connection");
        return (connection == null) ? getConnection(): connection;
    }

    private Connection getConnection() {
        return Pool.getInstance().getConnection();
    }
}

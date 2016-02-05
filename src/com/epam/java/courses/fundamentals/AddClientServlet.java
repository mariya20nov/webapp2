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

@WebServlet("/addclient")
public class AddClientServlet extends HttpServlet {
    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger4j.log = Logger.getLogger(AddClientServlet.class.getName());

        req.setCharacterEncoding("UTF-8");

        Client client = new Client(req.getParameter("clientname"), req.getParameter("clientmiddlename"),
                req.getParameter("clientsurname"), req.getParameter("clientpassport"));
        System.out.println("client surname:" + client.getSurname());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            Client.addClient(con, client.getName(), client.getMiddleName(), client.getSurname(), client.getPassport(), "");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/clients");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}


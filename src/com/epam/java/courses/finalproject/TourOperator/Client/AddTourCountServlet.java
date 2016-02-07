package com.epam.java.courses.finalproject.TourOperator.Client;


import com.epam.java.courses.finalproject.Logger4j;
import com.epam.java.courses.finalproject.dto.Client;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/addtourcount")
public class AddTourCountServlet extends HttpServlet {
    //private static final String GET_ALL_CLIENTS = "SELECT * FROM Client;";
    //todo считывать
    //private static final String INSERT_NEW_CLIENT = "INSERT INTO Client(name, middle_name, surname, passport, tour_count) VALUES('Пётр','Петрович','Петров','4013234567',0);";
    //private static String CHANGE_CLIENT = "INSERT FROM Client(name, middle_name, surname, passport, tour_count) VALUES(";
    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(AddTourCountServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            //todo проверка Integer.parseInt(req.getParameter("clientid"))
            //System.out.println(req.getParameter("clientid"));
            //System.out.println(req.getParameter("tourcounttoadd"));
            Client.addTourCount(con, new Integer(req.getParameter("clientid")),  new Integer(req.getParameter("tourcounttoadd")));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/touroperator/client/clients.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}


package com.epam.java.courses.finalproject.TourOperator.Client;


import com.epam.java.courses.finalproject.Logger4j;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Class for looking for clients via operator API
 */
@WebServlet("/findclient")
public class FindClientServlet extends HttpServlet {
    Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger4j.log = Logger.getLogger(FindClientServlet.class.getName());

        req.setCharacterEncoding("UTF-8");

        try {
            con = (Connection) req.getSession().getAttribute("con");;

            req.getSession().setAttribute("surname", "'"+req.getParameter("surname")+"'");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/touroperator/client/findclient2.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}


package com.epam.java.courses.finalproject.TourOperator.Form;


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
 * Class for looking for forms via operator API
 */
@WebServlet("/findform")
public class FindFormServlet extends HttpServlet {
    Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(FindFormServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            req.getSession().setAttribute("sqlstr", "SELECT * FROM Form WHERE client_id='"+req.getParameter("clientid")+"'");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/touroperator/form/findform2.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}


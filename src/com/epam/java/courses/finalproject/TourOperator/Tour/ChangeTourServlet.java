package com.epam.java.courses.finalproject.TourOperator.Tour;

import com.epam.java.courses.finalproject.Logger4j;
import com.epam.java.courses.finalproject.TourOperator.Client.ChangeClientServlet;
import com.epam.java.courses.finalproject.dto.Tour;
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
 * Class for changing tours via operator API
 */
@WebServlet("/changetour")
public class ChangeTourServlet extends HttpServlet {
    Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(ChangeClientServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            Tour.changeTour(con, new Integer(req.getParameter("tourid")), new Integer(req.getParameter("cost")));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/touroperator/tour/tours.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}


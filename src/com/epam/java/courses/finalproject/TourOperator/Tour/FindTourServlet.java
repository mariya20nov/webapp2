package com.epam.java.courses.finalproject.TourOperator.Tour;


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
 * Class for looking for tours via operator API
 */
@WebServlet("/findtour")
public class FindTourServlet extends HttpServlet {
    Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(FindTourServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            String sqlstr = "";

            if(!req.getParameter("country").isEmpty() && !req.getParameter("type").isEmpty()) {
                sqlstr = "SELECT Tour.* FROM Tour JOIN Type ON Tour.type_id=Type.type_id JOIN Resort ON Tour.resort_id=Resort.resort_id WHERE Resort.country='"
                        + req.getParameter("country") + "' AND Type.name=" + "'" + req.getParameter("type") + "';";
            }
            else if(!req.getParameter("country").isEmpty()) {
                sqlstr = "SELECT Tour.* FROM (Tour JOIN Resort ON Tour.resort_id=Resort.resort_id) WHERE Resort.country="
                        + "'" + req.getParameter("country") + "';";
            }
            else if (!req.getParameter("type").isEmpty()) {
                sqlstr = "SELECT Tour.* FROM (Tour JOIN Type ON Tour.type_id=Type.type_id) WHERE Type.name="
                        + "'" + req.getParameter("type") + "';";
            }
            else {
                sqlstr = "SELECT * FROM Tour;";
            }

            req.getSession().setAttribute("sqlstr", sqlstr);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/touroperator/tour/findtour2.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}


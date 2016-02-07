package com.epam.java.courses.finalproject.TourOperator.Tour;

import com.epam.java.courses.finalproject.Logger4j;
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
 * Created by maria on 01.02.16.
 */
@WebServlet("/addtour")
public class AddTourServlet extends HttpServlet {
    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(AddTourServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            //todo обработка дня месяца (28-февраль, 30 или 31)
            //todo проверка, чтобы дата конца была больше даты начала тура

            //todo нормально выбирать даты и курорты
            Tour.addTour(con, new Integer(req.getParameter("resortid")), new Integer(req.getParameter("typeid")), req.getParameter("name"),
                    new Timestamp(new Integer(req.getParameter("begyear")), new Integer(req.getParameter("begmonth")), new Integer(req.getParameter("begday")), 11, 0, 0, 0),
                    new Timestamp(new Integer(req.getParameter("endyear")), new Integer(req.getParameter("endmonth")), new Integer(req.getParameter("endday")), 11, 0, 0, 0), new Integer(req.getParameter("cost")));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/touroperator/tour/tours.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);;
        }
    }
}

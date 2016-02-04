package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.dto.Resort;
import com.epam.java.courses.fundamentals.dto.Tour;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

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
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8";
        String usr = "root";
        String password = "mkpwd";

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(AddTourServlet.class.getName());

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, password);

            //todo обработка дня месяца (28-февраль, 30 или 31)
            //todo проверка, чтобы дата конца была больше даты начала тура

            //todo нормально выбирать даты и курорты
            Tour.addTour(con, new Integer(req.getParameter("resortid")), new Integer(req.getParameter("typeid")), req.getParameter("name"),
                    new Timestamp(new Integer(req.getParameter("begyear")), new Integer(req.getParameter("begmonth")), new Integer(req.getParameter("begday")), 11, 0, 0, 0),
                    new Timestamp(new Integer(req.getParameter("endyear")), new Integer(req.getParameter("endmonth")), new Integer(req.getParameter("endday")), 11, 0, 0, 0), new Integer(req.getParameter("cost")));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/tours.jsp");
            requestDispatcher.forward(req, resp);

        } catch (ClassNotFoundException e) {
            Logger4j.log.error("Class.forName(driver) is not found. ", e);
        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                Logger4j.log.error("Closing connection exception. ", e);;
            }

        }
    }
}
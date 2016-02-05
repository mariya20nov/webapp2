package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.dto.Client;
import com.epam.java.courses.fundamentals.dto.Form;
import com.epam.java.courses.fundamentals.dto.Resort;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by maria on 01.02.16.
 */
@WebServlet("/buytour")
public class BuyTourServlet extends HttpServlet {
    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger4j.log = Logger.getLogger(AddFormServlet.class.getName());

        req.setCharacterEncoding("UTF-8");

        try {
            con = (Connection) req.getSession().getAttribute("con");

            Form.addForm(con, new Integer(req.getParameter("clientid")), new Integer(req.getParameter("tourid")));

             //req.getSession().setAttribute("client", req.getParameter("clientid"));


            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/ordinaryclient.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}
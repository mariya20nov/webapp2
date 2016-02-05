package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.dto.Client;
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
@WebServlet("/deleteresort")
public class DeleteResortServlet extends HttpServlet {

    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(DeleteResortServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            Resort.deleteResort(con, Integer.parseInt(req.getParameter("resortid")));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/resorts.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}

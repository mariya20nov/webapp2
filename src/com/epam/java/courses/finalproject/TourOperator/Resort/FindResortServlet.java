package com.epam.java.courses.finalproject.TourOperator.Resort;

import com.epam.java.courses.finalproject.Logger4j;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/findresort")
public class FindResortServlet extends HttpServlet {
    Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Logger4j.log = Logger.getLogger(FindResortServlet.class.getName());

        try {
            con = (Connection) req.getSession().getAttribute("con");

            req.getSession().setAttribute("resortname", "'"+req.getParameter("resortname")+"'");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/touroperator/resort/findresort2.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}

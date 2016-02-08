package com.epam.java.courses.finalproject.TourOperator.Resort;

import com.epam.java.courses.finalproject.Logger4j;
import com.epam.java.courses.finalproject.dto.Resort;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Class for deleting resorts via operator API
 */
@WebServlet("/deleteresort")
public class DeleteResortServlet extends HttpServlet {

    Connection con;

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

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/touroperator/resort/resorts.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}

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
import java.sql.Connection;

/**
 * Created by maria on 01.02.16.
 */
@WebServlet("/getdata")
public class GetDataServlet extends HttpServlet {
    Connection con;//mk

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger4j.log = Logger.getLogger(GetDataServlet.class.getName());

        req.setCharacterEncoding("UTF-8");

        try {
            con = (Connection) req.getSession().getAttribute("con");


            req.getSession().setAttribute("formid", req.getParameter("formid"));


            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/touroperator/form/getdata.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}
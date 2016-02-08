package com.epam.java.courses.finalproject.Client;

import com.epam.java.courses.finalproject.TourOperator.Form.AddFormServlet;
import com.epam.java.courses.finalproject.Logger4j;
import com.epam.java.courses.finalproject.dto.Form;
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
 * Class for adding new form via ordinary client API
 */
@WebServlet("/buytour")
public class BuyTourServlet extends HttpServlet {
    Connection con;

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

            Form.addForm(con, Integer.parseInt((String)req.getSession().getAttribute("Client")), new Integer(req.getParameter("tourid")));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/client/ordinaryclient.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            Logger4j.log.error("Connection to DB exception. ", e);
        }
    }
}
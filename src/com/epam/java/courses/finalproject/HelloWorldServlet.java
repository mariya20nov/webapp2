package com.epam.java.courses.finalproject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"tomcat"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"tomcat"}),
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"manager-gui"}),
        })
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       RequestDispatcher requestDispatcher = req.getRequestDispatcher("/touroperator");
        requestDispatcher.forward(req, resp);
    }
}

package com.epam.java.courses.fundamentals;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/j_security_check")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.login(
                request.getParameter("j_username"),
                request.getParameter("j_password")
        );

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main");
        requestDispatcher.forward(request, response);
    }
}

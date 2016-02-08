package com.epam.java.courses.finalproject;

import com.epam.java.courses.finalproject.cp.Pool;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/j_security_check")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        boolean rightPwd = false;

        Logger4j.log = Logger.getLogger(LoginServlet.class.getName());

        request.setCharacterEncoding("UTF-8");

        RequestDispatcher requestDispatcher;

        if (request.getParameter("j_username").equals("tomcat")) {
            request.login("tomcat", request.getParameter("j_password"));

            ////////////////
            //HttpSession se = request.getSession(true);
            //se.setAttribute("con", con);
            ////////////////

            requestDispatcher = request.getRequestDispatcher("/main");
        }
        else {
            try {
                con = getConnection(request);

                Statement statement = con.createStatement();

                String name = "", surname = "";

                ResultSet set = statement.executeQuery("SELECT * FROM Client WHERE client_id='" + request.getParameter("j_username") + "';");
                while(set.next()) {
                    if(set.getString("pwd").equals(request.getParameter("j_password"))) {
                        rightPwd = true;
                        name = set.getString("name");
                        surname = set.getString("surname");
                    }
                }


                ////////////////
                HttpSession se = request.getSession(true);
                se.setAttribute("con", con);
                se.setAttribute("client", request.getParameter("j_username"));
                se.setAttribute("clientname", name + " " + surname);
                ////////////////


            } /*catch (ClassNotFoundException e) {
                Logger4j.log.error("Class.forName(driver) is not found. ", e);
            }*/ catch (Exception e) {
                Logger4j.log.error("Connection to DB exception. ", e);
            }

            request.setAttribute("sqlstr", request.getParameter("j_username"));///

            if(rightPwd) {
                request.login("role1", "tomcat");
                requestDispatcher = request.getRequestDispatcher("/jsp/client/ordinaryclient.jsp");
            }
            else {
                requestDispatcher = request.getRequestDispatcher("/jsp/loginerror.jsp");
            }
        }
        requestDispatcher.forward(request, response);
    }


    private Connection getConnection(HttpServletRequest req) {
        Connection connection = (Connection) req.getAttribute("connection");
        return (connection == null) ? getConnection(): connection;
    }

    private Connection getConnection() {
        return Pool.getInstance().getConnection();
    }
}

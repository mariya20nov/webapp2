package com.epam.java.courses.fundamentals;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/j_security_check")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8";
        String usr = "root";
        String password = "mkpwd";
        Connection con = null;
        boolean rightPwd = false;

        Logger4j.log = Logger.getLogger(LoginServlet.class.getName());

        request.setCharacterEncoding("UTF-8");

        RequestDispatcher requestDispatcher;

        if (request.getParameter("j_username").equals("tomcat")) {
            request.login("tomcat", request.getParameter("j_password"));

            ////////////////
            HttpSession se = request.getSession(true);
            se.setAttribute("con", con);
            ////////////////

            requestDispatcher = request.getRequestDispatcher("/main");
        }
        else {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, password);

                Statement statement = con.createStatement();

                ResultSet set = statement.executeQuery("SELECT * FROM Client WHERE client_id='" + request.getParameter("j_username") + "';");
                while(set.next()) {
                    if(set.getString("pwd").equals(request.getParameter("j_password")))
                        rightPwd = true;
                }


                ////////////////
                HttpSession se = request.getSession(true);
                se.setAttribute("con", con);
                se.setAttribute("client", request.getParameter("j_username"));
                ////////////////


            } catch (ClassNotFoundException e) {
                Logger4j.log.error("Class.forName(driver) is not found. ", e);
            } catch (Exception e) {
                Logger4j.log.error("Connection to DB exception. ", e);
            }

            request.setAttribute("sqlstr", request.getParameter("j_username"));///

            if(rightPwd) {
                request.login("role1", "tomcat");
                requestDispatcher = request.getRequestDispatcher("/jsp/ordinaryclient.jsp");
            }
            else {
                requestDispatcher = request.getRequestDispatcher("/jsp/loginerror.jsp");
            }
        }
        requestDispatcher.forward(request, response);
    }
}

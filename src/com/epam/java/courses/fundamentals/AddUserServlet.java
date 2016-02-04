package com.epam.java.courses.fundamentals;

import com.epam.java.courses.fundamentals.dto.Client;
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

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.login("tomcat", "tomcat");

        Connection con = null;

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/TravelAgency?characterEncoding=UTF-8";
            String usr = "root";
            String password = "mkpwd";

            Logger4j.log = Logger.getLogger(AddUserServlet.class.getName());

            req.setCharacterEncoding("UTF-8");

            Client client = new Client(req.getParameter("clientname"), req.getParameter("clientmiddlename"),
                    req.getParameter("clientsurname"), req.getParameter("clientpassport"));
            System.out.println("client surname:" + client.getSurname());

            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, password);

                Client.addClient(con, client.getName(), client.getMiddleName(), client.getSurname(),
                        client.getPassport(), req.getParameter("clientpassword")); //todo

                req.setAttribute("sqlstr", "'"+client.getPassport()+"'");

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/signup2.jsp");
                requestDispatcher.forward(req, resp);

            } catch (ClassNotFoundException e) {
                Logger4j.log.error("Class.forName(driver) is not found. ", e);
            } catch (Exception e) {
                Logger4j.log.error("Connection to DB exception. ", e);
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (Exception e) {
                    Logger4j.log.error("Closing connection exception. ", e);
                }

            }
    }
}

package com.epam.java.courses.finalproject;

import javax.servlet.*;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebFilter;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/main")
@ServletSecurity(@HttpConstraint(rolesAllowed = "tomcat"))
public class ConnectionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try (Connection connection = getConnection()) {
            req.setAttribute("connection", connection);
            chain.doFilter(req, resp);
            req.removeAttribute("connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

    private Connection getConnection() {
        try {
            return Utils.<DataSource>localJndiSearch("jdbc/TestDB", DataSource.class).getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

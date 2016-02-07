package com.epam.java.courses.finalproject;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EpamListener implements ServletContextListener {
//public abstract class EpamListener implements ServletContextListener { //mk

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().getContextPath();
//        sce.getServletContext().addServlet("HelloWorldServlet", HelloWorldServlet.class).addMapping("/HelloToWorld");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

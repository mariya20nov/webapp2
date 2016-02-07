package com.epam.java.courses.finalproject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

@WebFilter("/main")
@WebInitParam(name = "Content-Type", value = "text/html")
public class ContentTypeFilter implements Filter {

    private Consumer<String> logger;
    private String contentType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger = filterConfig.getServletContext()::log;
        contentType = filterConfig.getInitParameter("Content-Type");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        log(() -> "Сообщение пришло!");

        resp.setContentType(contentType);
        chain.doFilter(req, resp);

        log(() -> "Сообщение ушло!");
    }

    @Override
    public void destroy() {

    }

    private void log(String msg) {
        logger.accept(msg);
    }

    private void log(Supplier<String> msg) {
        log(msg.get());
    }

}

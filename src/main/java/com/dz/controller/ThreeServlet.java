package com.dz.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ThreeServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("登录失败");
        HttpServletRequest request = (HttpServletRequest) req;
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("errName", name);
        servletContext.setAttribute("errPassword", password);

        HttpServletResponse response = (HttpServletResponse) res;
        response.sendRedirect("views/login.jsp");
    }
}

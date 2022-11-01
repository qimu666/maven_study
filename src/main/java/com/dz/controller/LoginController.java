package com.dz.controller;

import com.dz.entity.NewsUser;
import com.dz.service.NewsUserService;
import com.dz.service.impl.NewsUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private NewsUserService userService = new NewsUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println("post后台");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        NewsUser login = userService.login(name, password);

        HttpSession session = req.getSession();
        // 修改session会话的最大超时时间 setMaxInactiveInterval(int)
        session.setMaxInactiveInterval(1);
        System.out.println(session.getMaxInactiveInterval());
        System.out.println(session.getId());
        String page = "views/";
        if (null == login) {
            session.setAttribute("errName", name);
            session.setAttribute("errPassword", password);
            page += "login.jsp";

        } else {
            session.setAttribute("errName", null);
            session.setAttribute("errPassword", null);
            session.setAttribute("loginUser", login);
            page += "success.jsp";
        }
        resp.sendRedirect(page);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get后台");
    }
}

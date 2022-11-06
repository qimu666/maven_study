package com.dz.controller;

import com.dz.service.NewsUserService;
import com.dz.service.impl.NewsUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private NewsUserService userService = new NewsUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String email = req.getParameter("email");
        HttpSession session = req.getSession();
        String page = "views/register.jsp";
        if (!(password1.equals(password2))) {
            session.setAttribute("register", "密码不一样");
        } else if (username.trim().equals("")) {
            session.setAttribute("register", "账号不能为空");
        } else if (password1.trim().equals("") && password2.trim().equals("")) {
            session.setAttribute("register", "密码不能为空");
        } else if (email.trim().equals("")) {
            session.setAttribute("register", "邮箱不能为空");
        } else {
            Integer login = userService.register(username, password1, email);
            if (login != 0) {
                session.setAttribute("register", "注册成功");
                session.setAttribute("register", null);
                session.setAttribute("errName", null);
                session.setAttribute("errPassword", null);
                page = "views/login.jsp";
            } else {
                session.setAttribute("errName", "账号已存在");
                session.setAttribute("errPassword", null);
                page = "views/login.jsp";
            }
        }
        resp.sendRedirect(page);
    }
}

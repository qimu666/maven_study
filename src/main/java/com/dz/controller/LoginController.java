package com.dz.controller;

import com.dz.entity.NewsUser;
import com.dz.service.NewsUserService;
import com.dz.service.impl.NewsUserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController extends HttpServlet {
    private NewsUserService userService = new NewsUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post后台");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        NewsUser login = userService.login(name, password);
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();

        ServletContext application = req.getServletContext();
        Map<String, HttpSession> sessionMap = new HashMap<>();

        boolean isCookie = false;
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("session_id")) {
                break;
            }
            if (i == (cookies.length - 1)) {
                isCookie = true;
            }
        }


        // 修改session会话的最大超时时间 setMaxInactiveInterval(int)
        // session.setMaxInactiveInterval(1);
        System.out.println(session.getMaxInactiveInterval());
        System.out.println(session.getId());
        String page = "views/";
        if (null == login) {
            session.setAttribute("errName", name+"账号有误或不存在");
            session.setAttribute("errPassword", password+"密码有误");
            page += "login.jsp";
        } else {
            if (isCookie) {
                Cookie session_id = new Cookie("session_id", session.getId());
                session_id.setMaxAge(3600 * 24 * 7 + 3600 * 8);
                resp.addCookie(session_id);
                sessionMap.put(session.getId(), session);
                application.setAttribute("sessionMap", sessionMap);
            }
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
        HttpSession session = req.getSession();
        Integer kudos = (Integer) session.getAttribute("kudos");
        session.setAttribute("kudos", ++kudos);

        resp.sendRedirect("views/hello.jsp");
    }
}

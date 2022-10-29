package com.dz.controller;

import com.dz.entity.NewsUser;
import com.dz.service.NewsUserService;
import com.dz.service.impl.NewsUserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;

public class TestServlet implements Servlet {
    private NewsUserService userService = new NewsUserServiceImpl();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init被调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String name = servletRequest.getParameter("name");
        String password = servletRequest.getParameter("password");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        NewsUser newsUsers = new NewsUser();
        newsUsers.setUserName(name);
        newsUsers.setPassword(password);
        List<NewsUser> select = userService.select(newsUsers);


        HttpSession session = request.getSession();
        if (select.isEmpty()) {
//            System.out.println("登录失败");
            session.setAttribute("failure", "登陆失败,用户名或密码有误");
            response.sendRedirect("views/failure.jsp");
        } else {
            NewsUser newsUser = select.get(0);
            String userName = newsUser.getUserName();
            String password1 = newsUser.getPassword();
            System.out.println(userName + "---" + password1);
            session.setAttribute("loginUser", newsUser);
            response.sendRedirect("views/success.jsp");
//            request.getRequestDispatcher("views/success.jsp").forward(request, response);

        }


//        for (NewsUser newsUser : select) {
//            if ((newsUser.getUserName().equals(name)) && newsUser.getPassword().equals(password)) {
//                response.sendRedirect("views/success.jsp");
//                System.out.println(newsUser.getUserName() + "---" + newsUser.getPassword());
//                return;
//            }
//        }
//        response.sendRedirect("views/failure.jsp");
//        return;
////        request.getRequestDispatcher("views/failure.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy被调用");
    }
}

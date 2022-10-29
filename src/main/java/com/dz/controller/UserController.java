package com.dz.controller;


import com.dz.entity.NewsUser;
import com.dz.service.NewsUserService;
import com.dz.service.impl.NewsUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 控制器 与用户进行交互
 */
public class UserController extends HttpServlet {
    private NewsUserService userService = new NewsUserServiceImpl();

    public List<NewsUser> userList() {
        return userService.select(null);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("cotentType", "text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<meta charset=\"utf-8\">");
        writer.println("<body>");
        writer.println("<h1>eeeeeer钱钱钱钱钱</h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
        writer.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

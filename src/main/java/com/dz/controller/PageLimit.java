package com.dz.controller;


import com.alibaba.fastjson2.JSON;
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

public class PageLimit extends HttpServlet {
    private NewsUserService newsUserService = new NewsUserServiceImpl();

    public Integer getCount() {
        return newsUserService.getCount();
    }

    public List<NewsUser> getByLimit(Integer pag, Integer views) {
        return newsUserService.getByLimit(pag, views);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String view = req.getParameter("views");
        int pages = Integer.parseInt(page);
        int views = Integer.parseInt(view);
        List<NewsUser> byLimit = getByLimit(pages, views);
        PrintWriter writer = resp.getWriter();
        writer.println(JSON.toJSON(byLimit));
//        writer.println(byLimit);
        writer.flush();
        writer.close();
        System.out.println("post请求");
    }
}

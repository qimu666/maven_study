package com.dz.service.impl;


import com.dz.dao.NewsUserDAO;
import com.dz.dao.impl.NewsUserDAOImpl;
import com.dz.entity.NewsUser;
import com.dz.service.NewsUserService;

import java.util.List;


public class NewsUserServiceImpl implements NewsUserService {

    private NewsUserDAO userDAO = new NewsUserDAOImpl();

    @Override
    public List<NewsUser> select(NewsUser newsUser) {
        return userDAO.select(newsUser);
    }

    @Override
    public Integer insert(NewsUser newsUser) {
        return userDAO.insert(newsUser);
    }

    /**
     * login方法查询数据库中是否有数据
     *
     * @param username 用户名
     * @param password 密码
     * @return 存在返回一条数据, 不存在就返回null
     */
    @Override
    public NewsUser login(String username, String password) {

        NewsUser newsUser = new NewsUser();
        newsUser.setUserName(username);
        newsUser.setPassword(password);
        List<NewsUser> select = select(newsUser);
        if (select.isEmpty()) {
            return null;
        } else {
            return select.get(0);
        }
    }

    /**
     * 注册账号 先查询数据库是否存在数据,存在返回0，不存在调用insert()添加数据到数据库
     *
     * @param username 用户名
     * @param password 密码
     * @return 数据存在返回0，数据不存在并添加成功返回1
     */
    @Override
    public Integer register(String username, String password) {
        NewsUser newsUser = new NewsUser();
        newsUser.setUserName(username);
        newsUser.setPassword(password);
        List<NewsUser> select = select(newsUser);
        if (select.isEmpty()) {
            insert(newsUser);
            return 1;
        } else {
            return 0;
        }
    }
}

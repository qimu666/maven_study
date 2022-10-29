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
}

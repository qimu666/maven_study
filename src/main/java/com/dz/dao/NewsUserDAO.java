package com.dz.dao;

import com.dz.entity.NewsUser;

import java.util.List;

public interface NewsUserDAO extends BasicDAO<NewsUser> {
    /**
     * 通过用户名查询信息
     * @param newsUser
     * @return
     */
    List<NewsUser> getByUser(NewsUser newsUser);
}

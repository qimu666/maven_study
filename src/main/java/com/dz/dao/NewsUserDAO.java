package com.dz.dao;

import com.dz.entity.NewsUser;

import java.util.List;

public interface NewsUserDAO extends BasicDAO<NewsUser> {
    /**
     * 通过用户名查询信息
     *
     * @param newsUser
     * @return
     */
    List<NewsUser> getByUser(NewsUser newsUser);

    /**
     * 分页查询
     *
     * @param pag
     * @param views
     * @return
     */
    List<NewsUser> getByLimit(Integer pag, Integer views);

    Integer getCount();
}

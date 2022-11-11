package com.dz.dao;

import com.dz.entity.NewsUser;

import java.util.List;

public interface BasicDAO<E> {

    /**
     * 查询用户信息
     *
     * @param e
     * @return
     */
    List<E> select(E e);

    /**
     * 添加用户信息
     *
     * @param e
     * @return
     */
    Integer insert(E e);

    /**
     * 修改用户信息
     *
     * @param e
     * @return
     */
    Integer update(E e);

    /**
     * 删除用户信息
     *
     * @param e
     * @return
     */
    Integer delete(E e);

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

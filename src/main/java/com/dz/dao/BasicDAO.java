package com.dz.dao;

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
}

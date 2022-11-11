package com.dz.dao.impl;

import com.dz.dao.BasicDAO;
import com.dz.entity.NewsUser;

import java.util.List;

public class BasicDaoImpl<E> implements BasicDAO<E> {
    @Override
    public List<E> select(E e) {
        return null;
    }

    @Override
    public Integer insert(E e) {
        return null;
    }

    @Override
    public Integer update(E e) {
        return null;
    }

    @Override
    public Integer delete(E e) {
        return null;
    }

    @Override
    public List<NewsUser> getByUser(NewsUser newsUser) {
        return null;
    }

    @Override
    public List<NewsUser> getByLimit(Integer pag, Integer views) {
        return null;
    }

    @Override
    public Integer getCount() {
        return null;
    }
}

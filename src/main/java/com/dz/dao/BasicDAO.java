package com.dz.dao;

import java.util.List;

public interface BasicDAO<E> {

    List<E> select(E e);

    Integer insert(E e);

    Integer update(E e);

    Integer delete(E e);
}

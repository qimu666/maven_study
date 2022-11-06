package com.dz.service;


import com.dz.entity.NewsUser;

import java.util.List;

public interface NewsUserService {
    List<NewsUser> select(NewsUser newsUser);

    Integer insert(NewsUser newsUser);

    NewsUser login(String username, String password);

    Integer register(String username, String password,String email);

    List<NewsUser> getByUser(NewsUser newsUser);
}

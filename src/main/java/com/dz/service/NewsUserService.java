package com.dz.service;


import com.dz.entity.NewsUser;

import java.util.List;

public interface NewsUserService {
    List<NewsUser> select(NewsUser newsUser);
}

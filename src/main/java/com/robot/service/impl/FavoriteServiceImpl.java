package com.robot.service.impl;

import com.robot.dao.Favoritemapper;
import com.robot.pojo.Favorite;
import com.robot.pojo.FavoriteId;
import com.robot.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private Favoritemapper favoritemapper;
    @Override
    public boolean isFavorite(FavoriteId favoriteId) {
        Favorite favorite = favoritemapper.findByRidAndUid(favoriteId);
        return favorite!=null;//如果对象有值则为true;
    }

    @Override
    public void add(FavoriteId favoriteId) {
        favoritemapper.add(favoriteId);
    }
}

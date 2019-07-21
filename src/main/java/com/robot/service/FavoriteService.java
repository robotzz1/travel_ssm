package com.robot.service;

import com.robot.pojo.Favorite;
import com.robot.pojo.FavoriteId;

public interface FavoriteService {

    /**
     * 判断是否收藏
     * @param favoriteId
     * @return
     */
     public boolean isFavorite(FavoriteId favoriteId);

    /**
     * 添加收藏
     * @param favoriteId
     */
    void add(FavoriteId favoriteId);
}

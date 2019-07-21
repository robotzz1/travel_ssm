package com.robot.dao;

import com.robot.pojo.Favorite;
import com.robot.pojo.FavoriteId;

public interface Favoritemapper {

    /**
     * 根据rid和uid查询收藏信息
     * @param favoriteId
     * @return
     */
    public Favorite findByRidAndUid(FavoriteId favoriteId);

    /**
     * 根据rid查询收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);

    void add(FavoriteId favoriteId);
}


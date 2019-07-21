package com.robot.dao;

import com.robot.pojo.RouteImg;

import java.util.List;

public interface RouteImgemapper {

    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    public List<RouteImg> findById(int rid);
}

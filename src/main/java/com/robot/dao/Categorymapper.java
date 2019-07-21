package com.robot.dao;

import com.robot.pojo.Category;

import java.util.List;

public interface Categorymapper {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}

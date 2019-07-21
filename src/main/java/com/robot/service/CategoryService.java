package com.robot.service;

import com.robot.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}

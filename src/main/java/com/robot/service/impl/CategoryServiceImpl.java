package com.robot.service.impl;

import com.robot.dao.Categorymapper;
import com.robot.pojo.Category;
import com.robot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private Categorymapper mapper;
    @Override
    public List<Category> findAll() {
        return mapper.findAll();
    }
}

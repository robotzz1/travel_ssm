package com.robot.controller;

import com.robot.pojo.Category;
import com.robot.service.CategoryService;
import com.robot.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;
    @RequestMapping("findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //1.调用所有service查询所有
        List<Category> cs=service.findAll();
        //2.序列化json返回
        jsonUtil.writeValue(cs,response);

    }
}

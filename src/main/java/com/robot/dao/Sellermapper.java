package com.robot.dao;

import com.robot.pojo.Seller;

public interface Sellermapper {
    /**
     * 根据id查询
     * @param sid
     * @return
     */
    public Seller findById(int sid);
}

package com.robot.dao;

import com.robot.pojo.PageBean;
import com.robot.pojo.Route;

import java.util.List;

public interface Routemapper {

    /**
     * 根据cid查询总记录数
     */
    public int findTotalCount(PageBean pageBean);

    /**
     * 根据cid，start，pageSize查询当前页的数据集合
     */
    public List<Route> findByPage(PageBean pageBean);

    public Route findOne(int id);

}

package com.robot.service;

import com.robot.pojo.PageBean;
import com.robot.pojo.Route;

/**
 * 线路Service
 */

public interface RouteService {
    /**
     * 根据类别进行分页查询
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(String rid);
}

package com.robot.dao;

import com.robot.pojo.User;

public interface Usermapper {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    public void saveUser(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(User user);
}

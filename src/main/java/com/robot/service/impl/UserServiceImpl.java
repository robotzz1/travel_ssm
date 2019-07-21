package com.robot.service.impl;

import com.robot.dao.Usermapper;
import com.robot.pojo.User;
import com.robot.service.UserService;
import com.robot.util.MailUtils;
import com.robot.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Usermapper mapper;
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = mapper.findByUsername(user.getUsername());
        //判断u是否为null
        if(u != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        mapper.saveUser(user);

        //3.激活邮件发送，邮件正文？

        String content="<a href='http://localhost/travel_ssm/user/active?code="+user.getCode()+"'>点击激活【旅游网】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");

        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = mapper.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            mapper.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return mapper.findByUsernameAndPassword(user);
    }

}

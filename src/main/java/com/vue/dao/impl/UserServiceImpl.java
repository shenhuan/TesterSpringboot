package com.vue.dao.impl;

import com.vue.dao.UserService;
import com.vue.dao.mapper.UserMapper;
import com.vue.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @description 根据用户名查询用户信息
     * @author shenhuanhuan
     * @date 2019-06-13 10:37
     *判断当前接口是否登录成功
     */
    public User queryUserInfoEntityByUsername(String name,String password) {
        return userMapper.queryUserInfoEntityByUsername(name,password);
    }

}

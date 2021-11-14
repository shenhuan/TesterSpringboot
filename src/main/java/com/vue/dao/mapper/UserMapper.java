package com.vue.dao.mapper;

import com.vue.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User queryUserInfoEntityByUsername(@Param("username")String name, @Param("password")String password);
}

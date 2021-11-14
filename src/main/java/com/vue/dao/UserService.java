package com.vue.dao;

import com.vue.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
   User queryUserInfoEntityByUsername(String name, String password);
}

package com.vue.controller;

import com.vue.dao.impl.UserServiceImpl;
import com.vue.entity.User;
import com.vue.result.ResponseData;
import com.vue.result.error.ExceptionInfoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class LoginController {
    ResponseData resultData = null;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @RequestMapping(value="/loginInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData isLogin(String name,
                          String password) {
    //@RequestBody未使用，则取到的字段值为空
        System.out.printf("用户名" + name);
        System.out.printf("用户密码"+"\n");
        User userInfoEntity = userServiceImpl.queryUserInfoEntityByUsername(name,password);
        if(null!=userInfoEntity){
            System.out.println("登录界面列表："+ ResponseData.success());
            if(userInfoEntity.getUsername().equals(name)
                    &&userInfoEntity.getPassword().equals(password)){
                return ResponseData.success();
            }
            if(userInfoEntity.getUsername().equals(name)
                    &&!userInfoEntity.getPassword().equals(password)){
                return ResponseData.error(ExceptionInfoEnum.LOGIN_PASSWORD_ERROR);
            }
            if (!userInfoEntity.getUsername().equals(name)
                    &&userInfoEntity.getPassword().equals(password)){
                return ResponseData.error(ExceptionInfoEnum.LOGIN_USERNAME_ERROR);
            }
        }

    return ResponseData.error(ExceptionInfoEnum.NO_REGISTER);
}
//
//    @RequestMapping(value="/hello2")
//    @ResponseBody
//    public Object test2( String name,
//                         String password) {
////@RequestBody未使用，则取到的字段值为空
//        System.out.printf("用户名" + name);
//        System.out.printf("用户密码" + password);
//        return userService.isLogin(name,password);
//    }
//
//    @RequestMapping(value="/hello3")
//    public Object test3(String name,String password) {
//        //@RequestBody未使用，则取到的字段值为空
//
//        return userService.isLogin(name,password);
//    }
}

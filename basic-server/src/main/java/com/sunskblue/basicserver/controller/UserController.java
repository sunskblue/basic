package com.sunskblue.basicserver.controller;

import com.sunskblue.basicclient.bean.TUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @RequestMapping("/user")
    public String GetUser(){
        TUser tUser = new TUser();
        tUser.setPassword("password");
        tUser.setPhone("phone");
        tUser.setUserId(1);
        tUser.setUserName("username");
        return tUser.toString();
    }
}

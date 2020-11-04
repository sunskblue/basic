package com.sunskblue.basicserver.controller;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.service.impl.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user")
    public String GetUser() {
        TUser tUser = userService.SelectAll();
        return tUser.toString();
    }
}

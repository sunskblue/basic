package com.sunskblue.basicserver.controller;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.core.ResultGenerator;
import com.sunskblue.basicserver.core.ResultWrapper;
import com.sunskblue.basicserver.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/user")
    public ResultWrapper GetUser() {
        TUser tUser = userService.SelectAll();
        return ResultGenerator.genSuccessResult(tUser);
    }
}

package com.sunskblue.basicserver.service.impl;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public TUser SelectAll() {
        TUser sel = userMapper.SelectAll();
        System.out.println("===================" + sel.toString());
        return sel;
    }

}

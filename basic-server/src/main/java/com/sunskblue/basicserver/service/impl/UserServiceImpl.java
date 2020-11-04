package com.sunskblue.basicserver.service.impl;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.mapper.UserMapper;
import com.sunskblue.basicserver.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    public List<TUser> SelectAll() {
        return userMapper.SelectAll();
    }
}

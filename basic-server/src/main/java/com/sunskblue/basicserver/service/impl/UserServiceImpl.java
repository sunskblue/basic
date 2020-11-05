package com.sunskblue.basicserver.service.impl;

import com.google.gson.JsonObject;
import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.mapper.UserMapper;
import com.sunskblue.basicserver.service.UserService;
import com.sunskblue.basicserver.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    public List<TUser> SelectAll() {
        log.info("查询所有的用户");
        return userMapper.SelectAll();
    }

    @Override
    public void SaveUser(TUser tUser) {
        log.info("新增用户 入参 {}", GsonUtil.toJson(tUser));
        userMapper.SaveUser(tUser);
    }
}

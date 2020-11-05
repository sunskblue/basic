package com.sunskblue.basicserver.mapper;

import com.sunskblue.basicclient.bean.TUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<TUser> SelectAll();
    void SaveUser(TUser tUser);
    TUser SelectUserById(int userId);
}
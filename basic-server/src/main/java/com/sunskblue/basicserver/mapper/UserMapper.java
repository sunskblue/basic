package com.sunskblue.basicserver.mapper;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.dto.UserSearchParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<TUser> SelectAll();
    void SaveUser(TUser tUser);
    TUser SelectUserById(int userId);
    List<TUser> SelectAllUser(UserSearchParam userSearchParam);
}
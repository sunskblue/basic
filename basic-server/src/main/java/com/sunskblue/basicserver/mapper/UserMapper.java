package com.sunskblue.basicserver.mapper;

import com.sunskblue.basicclient.bean.TUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    TUser SelectAll();
}
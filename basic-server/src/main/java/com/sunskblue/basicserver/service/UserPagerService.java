package com.sunskblue.basicserver.service;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.dto.PageDTO;
import com.sunskblue.basicserver.dto.UserSearchParam;

import java.util.List;

/**
 * @author sunshaokang
 * @date Created in 2020/11/6 12:29 下午
 * Description：
 */
public interface UserPagerService {
    PageDTO<TUser> SelectAllUser(UserSearchParam userSearchParam);
}

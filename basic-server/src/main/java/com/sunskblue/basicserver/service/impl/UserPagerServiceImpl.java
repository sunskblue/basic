package com.sunskblue.basicserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.dto.PageDTO;
import com.sunskblue.basicserver.dto.UserSearchParam;
import com.sunskblue.basicserver.mapper.UserMapper;
import com.sunskblue.basicserver.service.UserPagerService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunshaokang
 * @date Created in 2020/11/6 12:41 下午
 * Description：
 */
@Service
public class UserPagerServiceImpl implements UserPagerService {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageDTO<TUser> SelectAllUser(UserSearchParam userSearchParam) {
        if (StringUtils.isEmpty(userSearchParam.getPageSize())){
            userSearchParam.init();
        }
        PageDTO<TUser> page = new PageDTO<>();
        PageHelper.startPage(userSearchParam.getPageNum(), userSearchParam.getPageSize());
        List<TUser> userList = userMapper.SelectAllUser(userSearchParam);
        page.setList(userList);
        long total = new PageInfo<>(userList).getTotal();
        page.setPageNum(userSearchParam.getPageNum());
        page.setPageSize(userSearchParam.getPageSize());
        long totalPage = total / userSearchParam.getPageNum() + 1;
        page.getTotalPage(totalPage);
        page.setCount(total);
        return page;
    }
}

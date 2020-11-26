package com.sunskblue.basicserver;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.dto.PageDTO;
import com.sunskblue.basicserver.dto.UserSearchParam;
import com.sunskblue.basicserver.service.UserPagerService;

import com.sunskblue.basicserver.service.impl.UserPagerServiceImpl;
import com.sunskblue.basicserver.service.impl.UserServiceImpl;
import com.sunskblue.basicserver.util.GsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunshaokang
 * @date Created in 2020/11/5 4:30 下午
 * Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BasicServerApplication.class)
public class UserTest {
    @Autowired
    private UserServiceImpl userService;
    @Resource
    private UserPagerServiceImpl userPagerService;

    @Test
    public void testcase() {
        List<TUser> tUsers = userService.SelectAll();
        System.out.println("===================" + GsonUtil.toJson(tUsers));
    }

    @Test
    public void testPage() {
        UserSearchParam userSearchParam = new UserSearchParam();
        userSearchParam.setCurrentPage(2);
        userSearchParam.setPageSize(1);
        PageDTO<TUser> tUserPageDTO = userPagerService.SelectAllUser(userSearchParam);
        System.out.println(tUserPageDTO);
    }
}

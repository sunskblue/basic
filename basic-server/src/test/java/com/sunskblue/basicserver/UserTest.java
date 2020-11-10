package com.sunskblue.basicserver;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.dto.UserSearchParam;
import com.sunskblue.basicserver.service.UserPagerService;

import com.sunskblue.basicserver.service.impl.UserServiceImpl;
import com.sunskblue.basicserver.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author sunshaokang
 * @date Created in 2020/11/5 4:30 下午
 * Description：
 */
@SpringBootTest(classes = BasicServerApplication.class)
public class UserTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testcase() {
        List<TUser> tUsers = userService.SelectAll();
        System.out.println("===================" + GsonUtil.toJson(tUsers));
    }

    @Autowired
    private UserPagerService userPagerService;

    @Test
    public void testPage() {
        UserSearchParam userSearchParam = new UserSearchParam();
        userSearchParam.setUserId(1000);

//        ResultWrapper<Page<List<TUser>>> pageResultWrapper = userPagerService.SelectAllUser(userSearchParam);
//        System.out.println("=====================" + GsonUtil.toJson(pageResultWrapper));
    }
}

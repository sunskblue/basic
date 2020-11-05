package com.sunskblue.basicserver;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.service.UserService;

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
    private UserService userService;

    @Test
    public void testcase(){
        List<TUser> tUsers = userService.SelectAll();
        System.out.println(tUsers.toString());
    }
}

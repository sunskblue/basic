package com.sunskblue.basicserver.controller;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.core.ResultGenerator;
import com.sunskblue.basicserver.core.ResultWrapper;
import com.sunskblue.basicserver.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
@Api(tags = "用户")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    /**
     * 查询用户
     *
     * @return
     */
    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultWrapper<List<TUser>> GetUser() {
        List<TUser> userList = userService.SelectAll();
        return ResultGenerator.genSuccessResult(userList);
    }
}

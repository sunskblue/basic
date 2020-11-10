package com.sunskblue.basicserver.controller;

import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.core.ResultGenerator;
import com.sunskblue.basicserver.core.ResultWrapper;
import com.sunskblue.basicserver.dto.PageDTO;
import com.sunskblue.basicserver.dto.UserSearchParam;
import com.sunskblue.basicserver.service.impl.UserPagerServiceImpl;
import com.sunskblue.basicserver.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/test")
@Api(tags = "用户")
@Slf4j
public class UserController {

    @Resource
    private UserServiceImpl userService;
    @Resource
    private UserPagerServiceImpl userPagerService;

    /**
     * 查询用户
     *
     * @return
     */
    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResultWrapper<List<TUser>> GetUser() {
        List<TUser> userList = userService.SelectAll();
        return ResultGenerator.genSuccessResult(userList);
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResultWrapper SaveUser(@RequestBody @Valid TUser tUser) {
        userService.SaveUser(tUser);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/getPagerUser", method = RequestMethod.POST)
    public ResultWrapper<PageDTO<List<TUser>>> GetPagerUser(UserSearchParam userSearchParam) {
        PageDTO<TUser> listPage = userPagerService.SelectAllUser(userSearchParam);
        ResultWrapper resultWrapper = new ResultWrapper<>().setData(listPage);
        return resultWrapper;
    }

}

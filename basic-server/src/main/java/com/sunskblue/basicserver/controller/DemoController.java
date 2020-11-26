package com.sunskblue.basicserver.controller;

import com.sunskblue.basicclient.bean.Select;
import com.sunskblue.basicclient.bean.TUser;
import com.sunskblue.basicserver.core.ResultGenerator;
import com.sunskblue.basicserver.core.ResultWrapper;
import com.sunskblue.basicserver.dto.PageDTO;
import com.sunskblue.basicserver.dto.UserSearchParam;
import com.sunskblue.basicserver.service.impl.UserPagerServiceImpl;
import com.sunskblue.basicserver.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunshaokang
 * @date Created in 2020/11/24 2:59 下午
 * Description：
 */
@RestController
@Slf4j
public class DemoController {

    @Resource
    private UserPagerServiceImpl userPagerService;

    @RequestMapping(value = "/getAllSelect", method = RequestMethod.GET)
    public ResultWrapper getAllSelect() {
        List list = new ArrayList();
        Select select1 = new Select();
        select1.setSelectId(1);
        select1.setContent("选项 1");
        Select select2 = new Select();
        select2.setSelectId(2);
        select2.setContent("选项 ......");
        list.add(select1);
        list.add(select2);
        Map<String, Object> selects = new HashMap<>();
        selects.put("selectInfos", list);
        return ResultGenerator.genSuccessResult(selects);
    }

    @RequestMapping(value = "/getDataList", method = RequestMethod.POST)
    public ResultWrapper getDataList(@RequestBody UserSearchParam userSearchParam) {
        PageDTO<TUser> listPage = userPagerService.SelectAllUser(userSearchParam);
        ResultWrapper resultWrapper = new ResultWrapper<>().setData(listPage);
        return resultWrapper;
    }
}

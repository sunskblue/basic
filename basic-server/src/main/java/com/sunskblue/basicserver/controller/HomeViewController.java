package com.sunskblue.basicserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sunshaokang
 * @date Created in 2020/11/10 4:05 下午
 * Description：
 */
@Controller
@Slf4j
public class HomeViewController {
    /**
     * 跳转首页Controller
     *
     * @return
     */
    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:/testPlatform/demo";
    }

    /**
     * 跳转 demo 页面
     *
     * @return
     */
    @RequestMapping(path = "/testPlatform/demo", method = RequestMethod.GET)
    public String showToolList() {
        return "demo";
    }

}

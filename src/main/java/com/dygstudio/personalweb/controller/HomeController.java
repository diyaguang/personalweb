package com.dygstudio.personalweb.controller;

import com.dygstudio.personalweb.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author: diyaguang
 * @date: 2018/01/30 下午8:16
 * @description: com.dygstudio.personalweb.controller
 */
@RestController
public class HomeController {

    @Autowired
    CommonService commonService;

    @RequestMapping("/")
    public String home(){
        return "hello my site";
    }

    @RequestMapping("/initData")
    public String initData() throws ParseException{
        commonService.testFirstInitData();
        return "init data ok";
    }

}

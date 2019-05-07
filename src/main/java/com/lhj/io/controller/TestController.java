package com.lhj.io.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/5/6 18:54
 * @Version: 1.0
 */
@RestController
public class TestController {

    @RequestMapping("/ss")
    public String test() {
        return "123123";
    }


}

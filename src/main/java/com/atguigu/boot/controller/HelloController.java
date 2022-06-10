package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    //请求进来时会先去Controller找，不能处理所有请求时再交给静态处理，再不行返回404
    //(@RequestParam("username") String name,从请求参数的地方拿到username, 然后复制给name,方便后续使用
    public String Hello(@RequestParam("username") String name){
        return "aaa";
    }
}

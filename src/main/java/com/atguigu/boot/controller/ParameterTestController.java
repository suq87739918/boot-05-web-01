package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ObjIntConsumer;

@RestController
public class ParameterTestController {
    @RequestMapping("/car/{id}/owner/{username}")    //返回当前id对应的结果
    public Map<String, Object>getCar(@PathVariable("id") Integer id,
                                    @PathVariable("username") String name,
                                     @PathVariable Map<String, String> pv){   //@PathVariable("id")让id根据路径变化自动变化
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv",pv);
        return null;
    }
}

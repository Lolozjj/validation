package cn.zjj.controller;

import cn.zjj.params.GetParams;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/get")
    public void get(@Validated GetParams params) {
        System.out.println(params);
    }

    @PostMapping("/post")
    public void post(@Validated @RequestBody GetParams params) {
        System.out.println(params);
    }
}

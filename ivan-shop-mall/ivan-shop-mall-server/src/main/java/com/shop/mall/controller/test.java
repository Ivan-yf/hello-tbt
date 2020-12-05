package com.shop.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan.luo
 * @Description
 * @date 2020/12/05
 */
@RestController
public class test {
    @GetMapping("/test")
    public void test(){
        System.out.println("hello");
    }
}

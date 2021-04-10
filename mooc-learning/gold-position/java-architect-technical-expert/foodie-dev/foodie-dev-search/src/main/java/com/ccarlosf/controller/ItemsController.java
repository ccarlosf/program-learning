package com.ccarlosf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
public class ItemsController {

    @GetMapping("/hello")
    public Object hello() {
        return "Hello Elasticsearch~";
    }
}

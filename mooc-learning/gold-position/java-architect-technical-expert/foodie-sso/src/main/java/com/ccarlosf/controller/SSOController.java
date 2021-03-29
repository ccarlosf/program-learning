package com.ccarlosf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SSOController {

    @ResponseBody
    @GetMapping("/login")
    public String login() {
        return "Hello World~";
    }
}

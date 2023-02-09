package com.fastcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Router URl : / 설정
@Controller(value = "/")
public class IndexController {
    @GetMapping("/")
    public String homeMethod() {
        return "index";
    }
}

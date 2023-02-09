package com.fastcampus.controller.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class UserRestController {

    @GetMapping("/api/users")
    public String[] users() {
        List<String> list = new ArrayList<>();

        list.add("Home");
        list.add("Come");
        list.add("Park");

        return list.toArray(new String[0]);
    }
}

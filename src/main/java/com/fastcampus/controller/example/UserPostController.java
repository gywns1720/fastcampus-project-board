package com.fastcampus.controller.example;

import com.fastcampus.dto.example.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * GET -> GetMapping    : @RequestParam
 * POST -> PostMapping : @RequestBody, @RequestParam
 */
@Controller
public class UserPostController {

    // @RequestBody String req -> req 부분은 form 의 input 태그의 name 과 같아야 합니다.
    // Dto 방식을 이용하여 전달 하기
    @PostMapping("/user")
    public String postUser(UserDto userDto, Model model) {

        System.out.println(userDto.getUserId());
        System.out.println(userDto.getUserName());
        System.out.println(userDto.getUserPhone());



        return "user/post/user-post";
    }
}

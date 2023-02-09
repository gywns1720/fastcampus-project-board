package com.fastcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class UserController {

    @GetMapping("/user")
    public String ViewPage() {
        return "user/user";
    }

    @GetMapping("/user/userdata")
    public String userData(Model model) {
        // 데이터와 함께 HTML 그리기
        // View page에 데이터를 전송
        model.addAttribute("username", "홍길동");
        return "user/userinfo";
    }

    @GetMapping("/user/userid") // URL: /user/userid?userid=30
    public String userID(@RequestParam(value = "userid", required = true) String uid, Model model) {

        /**
         * RequestParam [필드 종류]
         * name : 바인드할 요청 매개변수의 이름입니다.
         * value : name 의 별명 (name 가 똑같은 기능)
         * required : 필수로 입력해야하는지 체크하며, 입력을 안할 시 에러페이지를 띄운다.
         *          기본값은 false 로 되어있으며, 안 써도 false 값으로 넣어진다.
         *          이 경우에는 반드시 주소창에 파라미터 값을 넣어 HTTP 요청을 해야한다.
         *          안그러면 Error Page 적용
         *          보통은 @RequestParam("userid") 로 사용해도 된다.
         * defaultValue : 요청 매개변수에 값이 안들어 올 때 기본값을 넣는다.
         *           required 는 false 로 적용해야 한다.
         */
        model.addAttribute("username", uid);
        return "user/userinfo";
    }
}

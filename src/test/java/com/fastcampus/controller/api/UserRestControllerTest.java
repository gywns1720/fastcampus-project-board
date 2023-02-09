package com.fastcampus.controller.api;


import com.fastcampus.controller.example.UserRestController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserRestController.class)
public class UserRestControllerTest {
    // 작성한 코드가 재대로 작동하는지 테스트를 합니다.
    // Was 를 실행하지 않고, 테스트 코드로 검증합니다.

    @Autowired
    private MockMvc mvc;

    @DisplayName("유저를 불러옵니다.")
    @Test
    public void findUsers() throws Exception {
        String hello = "Hello";
        mvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(hello));
    }
}

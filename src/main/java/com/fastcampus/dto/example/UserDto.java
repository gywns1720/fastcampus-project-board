package com.fastcampus.dto.example;

import lombok.Getter;
import lombok.Setter;

/**
 * Getter -> 필드 변수들을 전부 Getter 만들어 준다. (읽기)
 * Setter -> 필드 변수들을 전부 Setter 만들어 준다. (수정)
 */
@Getter
@Setter
public class UserDto {
    String userName;
    String userId;
    String userPhone;

    protected UserDto() {}

    private UserDto(String name, String id, String phone) {
        this.userId = id;
        this.userName = name;
        this.userPhone = phone;
    }

    public static UserDto of(String name, String id, String phone) {
        return new UserDto(name, id, phone);
    }
}

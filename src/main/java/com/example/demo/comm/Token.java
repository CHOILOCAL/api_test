package com.example.demo.comm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Token {

    JSESSION("JSESSION", "쿠키") // 로그인 || 로그아웃시 사용
    ,ROLE_ADMIN("ADMIN", "관리자")
    ,ROLE_USER("USER", "사용자");

    private String value;
    private String desc;

}

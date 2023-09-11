package com.example.demo.comm;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
public enum ResponseCode {

    LOGIN_SUCCESS("0000", "로그인 되었습니다. "),
    LOGIN_ERROR("9999", "아이디 혹은 패스워드를 확인해주세요. "),

    SAVE_SUCCESS("0000", "정상적으로 저장 되었습니다."),
    SAVE_ERROR("9999", "저장이 실패했습니다."),
    DELETE_SUCCESS("",""),
    DELETE_ERROR("","");

    private String code;
    private String meg;
}

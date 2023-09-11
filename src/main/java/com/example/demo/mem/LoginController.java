package com.example.demo.mem;


import com.example.demo.comm.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Member member) {
        Member mem = memberService.login(member);
        String res = ResponseCode.LOGIN_ERROR.getMeg();
        if (mem == null) {
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        } else {
            res = ResponseCode.LOGIN_SUCCESS.getMeg();
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody Member req) {
        return "signup";
    }
}

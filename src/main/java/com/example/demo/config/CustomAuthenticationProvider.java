//package com.example.demo.config;
//
//import com.example.demo.mem.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
//
//        String ID = token.getName();
//        String PWD = (String) token.getCredentials();
//
//        Member mem = new Member();
//        // ... DB에서 아이디로 사용자 조회
//        if (!passwordEncoder.matches(PWD, mem.getPWD())) {
//            throw  new BadCredentialsException(mem.getID() + " 잘못된 패스워드입니다. ");
//        }
//
//        // 접근 대상, 비밀번호, 권한 목록
//        return new UsernamePasswordAuthenticationToken(mem, mem.getPWD(), mem.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}

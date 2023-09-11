//package com.example.demo.config;
//
//import com.example.demo.comm.Token;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///*
//* 인증 | 인가의 차이 !!!
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    // 비밀번호 암호화 로직
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    // 권한이 없는 사용자 접근에 대한 Handler
//    @Autowired
//    private WebAccessDeniedHandler webAccessDeniedHandler;
//
//    // 인증되지 않은 사용자 접근에 대한 Handler
//    @Autowired
//    private WebAuthenticationEntryPoint webAuthenticationEntryPoint;
//
//    // 실제 인증을 담당하는 Provider
//    @Bean
//    public CustomAuthenticationProvider customAuthenticationProvider() {
//        return new CustomAuthenticationProvider(passwordEncoder);
//    }
//
//    // 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
//        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .antMatcher("/**").authorizeRequests()
//                .antMatchers("/index").permitAll()
//                .antMatchers("/imsi").authenticated() // TODO: 인증된 사용자만 접근 가능한 라우터
//                .antMatchers("/all").anonymous() // TODO: 인증되지 않은 사용자만 접근 가능
//                .antMatchers("/admin").hasRole("ADMIN") // ROLE_ADMIN 권한을 가진 사용자만 접근 가능
//                .anyRequest()
//                .authenticated()
//                .and()
//
//                // 핸들링
//                .exceptionHandling()
//                .accessDeniedHandler(webAccessDeniedHandler) // 권한이 없는 사용자 접근시
//                .authenticationEntryPoint(webAuthenticationEntryPoint) // 인증되지 않은 사용자 접근
//
//                // 로그인하는 경우 설정
//                .and()
//                .formLogin()
//                .loginPage("/auth/login") // 로그인 페이지 URL 설정
//                .successForwardUrl("index") // 로그인 성공 후 이동할 URL 설정
//                .permitAll()
//
//                // 로그아웃 경우 설정
//                .and()
//                .logout()
//                .logoutUrl("/auth/logout") // 로그아웃 페이지 URL 설정
//                .logoutSuccessUrl("index") // 로그아웃 성공 후 이동할 URL 설정
//                .deleteCookies(Token.JSESSION.getValue()) // 로그아웃 후 쿠키 삭제 설정
//
//                // 사용자 인증 필터 적용
//                .and()
//                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//
//    /*
//    * 스프링 시큐리티 룰을 무시할 URL 규칙 적용
//    * 정적 자원에 대해서 Security 설정을 적용하지 않음
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/resources/**")
//                .antMatchers("/css/**")
//                .antMatchers("/vendor/**")
//                .antMatchers("/js/**")
//                .antMatchers("/favicon*/**")
//                .antMatchers("/img/**");
//    }
//
//    /*
//    * customLoginSuccessHandler를 CustomAuthenticationFilter의 인증 성공 핸들러로 추가
//    * 로그인 성공 시 '/auth/login' 로그인 url을 체크하고 인증 토큰 발급
//     */
//    @Bean
//    public UsrCustomAuthenticationFilter usrCustomAuthenticationFilter() throws Exception {
//        UsrCustomAuthenticationFilter customAuthenticationFilter = new UsrCustomAuthenticationFilter(authenticationManager());
//        customAuthenticationFilter.setFilterProcessesUrl("/auth/login");
//        customAuthenticationFilter.setAuthenticationSuccessHandler(usrCustomLoginSuccessHandler());
//        customAuthenticationFilter.setAuthenticationFailureHandler(usrCustomLoginFailHandler());
//        customAuthenticationFilter.afterPropertiesSet();
//        return customAuthenticationFilter;
//    }
//
//    /*
//     * 로그인 성공 시 실행될 Handler bean 등록
//     */
//    @Bean
//    public UsrCustomLoginSuccessHandler usrCustomLoginSuccessHandler() {
//        return new UsrCustomLoginSuccessHandler();
//    }
//
//    /*
//     * 로그인 실패 시 실행될 Handler bean 등록
//     */
//    @Bean
//    public UsrCustomLoginFailHandler usrCustomLoginFailHandler() {
//        return new UsrCustomLoginFailHandler();
//    }
//
//
//
//
//}

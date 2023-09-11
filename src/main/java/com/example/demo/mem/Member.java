package com.example.demo.mem;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@ToString
//public class Member implements UserDetails {
public class Member {
    private String MEMID;
    private String ID;
    private String PWD;
    private String NAME;


}

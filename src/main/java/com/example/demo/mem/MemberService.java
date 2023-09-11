package com.example.demo.mem;

import java.util.List;

public interface MemberService {

    public List<Member> list();

    public void add(Member member);

    public void put(Member member);

    public void del(String id);

    // 로그인
    public Member login(Member member);

}

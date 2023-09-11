package com.example.demo.mem;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<Member> list();

    public void add(Member member);

    public void put(Member member);

    public void del(String id);

    public Member login(Member member);

}

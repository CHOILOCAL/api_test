package com.example.demo.mem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> list() {
        //TODO: 서비스 로직
        return memberMapper.list();
    }

    @Override
    public void add(Member member) {
        //TODO: 비밀번호 암호화
        memberMapper.add(member);
    }

    @Override
    public void put(Member member) {
        //TODO: 비밀번호 암호화
        memberMapper.put(member);
    }

    @Override
    public void del(String id) {
        //TODO: 서비스 로직
         memberMapper.del(id);
    }

    @Override
    public Member login(Member member) {
        Member loginMember = memberMapper.login(member);
        return loginMember;
    }


}

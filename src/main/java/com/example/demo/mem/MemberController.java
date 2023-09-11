package com.example.demo.mem;


import com.example.demo.comm.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/member")
    public List<Member> getTest() {
        List<Member> res = memberService.list();
        return res;
    }

    @PostMapping("/member/add")
    public ResponseEntity<?> addMember(@RequestBody Member member) {
        memberService.add(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/member/put")
    public ResponseEntity<? extends Member> putMember(@RequestBody Member member) {
        memberService.put(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/member/delete")
    public String deleteMember(@RequestParam("id") String id) {
        System.out.println("id = " + id);
        memberService.del(id);
        return "redirect:/";
    }
}

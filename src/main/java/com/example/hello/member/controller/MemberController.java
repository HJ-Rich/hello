package com.example.hello.member.controller;

import com.example.hello.member.domain.Member;
import com.example.hello.member.dto.MemberResponse;
import com.example.hello.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> findById(@PathVariable Long memberId) {
        Member member = memberService.findById(memberId);
        MemberResponse memberResponse = MemberResponse.from(member);
        return ResponseEntity.ok(memberResponse);
    }
}

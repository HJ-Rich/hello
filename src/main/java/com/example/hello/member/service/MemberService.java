package com.example.hello.member.service;

import com.example.hello.member.domain.Member;

public interface MemberService {

    Member findById(Long memberId);
}

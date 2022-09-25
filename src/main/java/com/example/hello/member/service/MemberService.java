package com.example.hello.member.service;

import com.example.hello.member.domain.Member;
import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findById(Long memberId);
}

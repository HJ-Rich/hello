package com.example.hello.member.service;

import com.example.hello.member.domain.Member;
import com.example.hello.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MockMemberService implements MemberService {

    private final MemberRepository memberRepository;

    public MockMemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findById(final Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member does not exist"));
    }
}

package com.example.hello.member.repository;

import com.example.hello.member.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    List<Member> findAll();
    Optional<Member> findById(Long memberId);
}

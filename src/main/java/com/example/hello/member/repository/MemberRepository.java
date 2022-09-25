package com.example.hello.member.repository;

import com.example.hello.member.domain.Member;
import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findById(Long memberId);
}

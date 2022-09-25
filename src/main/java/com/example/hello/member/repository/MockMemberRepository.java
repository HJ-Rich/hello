package com.example.hello.member.repository;

import com.example.hello.member.domain.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MockMemberRepository implements MemberRepository {

    private final Map<Long, Member> members;

    public MockMemberRepository() {
        this.members = new HashMap<>();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Optional<Member> findById(final Long memberId) {
        return Optional.ofNullable(members.get(memberId));
    }
}

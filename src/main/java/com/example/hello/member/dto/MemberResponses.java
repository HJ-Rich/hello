package com.example.hello.member.dto;

import com.example.hello.member.domain.Member;
import java.util.List;
import java.util.stream.Collectors;

public class MemberResponses {

    private final List<MemberResponse> memberResponses;

    public MemberResponses(final List<MemberResponse> memberResponses) {
        this.memberResponses = memberResponses;
    }

    public static MemberResponses from(final List<Member> members) {
        return new MemberResponses(
                members.stream()
                        .map(MemberResponse::from)
                        .collect(Collectors.toList())
        );
    }

    public List<MemberResponse> getMemberResponses() {
        return memberResponses;
    }
}

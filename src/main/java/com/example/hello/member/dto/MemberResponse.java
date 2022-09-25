package com.example.hello.member.dto;


import com.example.hello.member.domain.Member;

public class MemberResponse {

    private final Long id;
    private final String name;
    private final String imageUrl;

    public MemberResponse(final Long id, final String name, final String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public static MemberResponse from(final Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getImageUrl()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

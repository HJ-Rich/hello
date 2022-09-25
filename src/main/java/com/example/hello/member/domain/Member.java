package com.example.hello.member.domain;

public class Member {

    private final Long id;
    private final String name;
    private final String imageUrl;

    public Member(final Long id, final String name, final String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
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

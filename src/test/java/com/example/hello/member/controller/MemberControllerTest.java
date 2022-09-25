package com.example.hello.member.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

import com.example.hello.DocumentationTest;
import com.example.hello.member.domain.Member;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class MemberControllerTest extends DocumentationTest {

    @DisplayName("전체 회원 조회")
    @Test
    void find_all_members() {
        given(memberService.findAll())
                .willReturn(
                        List.of(
                                new Member(11L, "Richard11", "https://richard11.png"),
                                new Member(12L, "Richard12", "https://richard12.png"),
                                new Member(13L, "Richard13", "https://richard13.png")
                        )
                );

        docsGiven
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/members")
                .then().log().all()
                .apply(document("members/findAll"))
                .statusCode(HttpStatus.OK.value());
    }

    @DisplayName("아이디로 단일 회원 조회")
    @Test
    void find_single_member_using_memberId() {
        given(memberService.findById(any()))
                .willReturn(new Member(11L, "Richard", "https://richard.png"));

        docsGiven
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/api/members/11")
                .then().log().all()
                .apply(document("members/findById"))
                .statusCode(HttpStatus.OK.value());
    }
}

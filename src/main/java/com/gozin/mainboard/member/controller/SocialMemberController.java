package com.gozin.mainboard.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gozin.mainboard.member.dto.MemberDTO;
import com.gozin.mainboard.member.dto.SocialMemberDTO;
import com.gozin.mainboard.member.service.SocialMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/oauth")
public class SocialMemberController {

    private final SocialMemberService socialMemberService;

    public SocialMemberController(SocialMemberService socialMemberService) {
        this.socialMemberService = socialMemberService;
    }

    @GetMapping("/kakao")
    public MemberDTO kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return socialMemberService.kakaoLogin(code, response);
    }
}

package com.gozin.mainboard.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.member.service.SocialMemberService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.HashMap;

@RestController
@RequestMapping("/oauth")
public class SocialMemberController {

    private final SocialMemberService socialMemberService;

    public SocialMemberController(SocialMemberService socialMemberService) {
        this.socialMemberService = socialMemberService;
    }

    @GetMapping("/kakaoAPICall")
    public ResponseEntity<ResponseDTO> kakaoApiCall() throws IOException, URISyntaxException {

        String stringUrl = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=dec28fd3dd5d81e0b10184358994c44c&redirect_uri=http://localhost:8080/oauth/kakao";
        URI redirectUri = new URI(stringUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<ResponseDTO>(httpHeaders, HttpStatus.SEE_OTHER);

//      HashMap<String, Object> result = new HashMap<>();
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders header = new HttpHeaders();
//        HttpEntity<>
    }

    @GetMapping("/kakao")
    public ResponseEntity<ResponseDTO> kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return socialMemberService.kakaoLogin(code, response);
    }
}

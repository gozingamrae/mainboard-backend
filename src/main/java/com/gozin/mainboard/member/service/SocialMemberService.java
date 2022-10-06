package com.gozin.mainboard.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.jwt.TokenProvider;
import com.gozin.mainboard.member.dao.MemberMapper;
import com.gozin.mainboard.member.dto.MemberDTO;
import com.gozin.mainboard.member.dto.SocialMemberDTO;
import com.gozin.mainboard.member.dto.TokenDTO;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class SocialMemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;
    private final TokenProvider tokenProvider;


    public SocialMemberService(PasswordEncoder passwordEncoder, MemberMapper memberMapper, TokenProvider tokenProvider) {
        this.passwordEncoder = passwordEncoder;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public ResponseEntity<ResponseDTO> kakaoLogin(String code, HttpServletResponse response) throws JsonProcessingException {
        String accessToken = tokenProvider.getKakaoAccessToken(code);
        SocialMemberDTO member = getSocialMember(accessToken);
        MemberDTO kakaoMember = registerKakaoMember(member);
//        TokenDTO token = tokenProvider.generateTokenDTO(kakaoMember);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", accessToken ));

    }


    public MemberDTO registerKakaoMember(SocialMemberDTO member) {
        String memberId = member.getMemberId();
        String email = member.getEmail();
        String memberName = member.getMemberName();
        MemberDTO newMember = new MemberDTO();

        MemberDTO mem =  memberMapper.findByEmail(email);

        System.out.println("newMember = " + newMember);

        if(mem == null){
            String password = UUID.randomUUID().toString();
            String encodePassword = passwordEncoder.encode(password);
            newMember.setMemberId(memberId);
            newMember.setMemberPwd(encodePassword);
            newMember.setEmail(email);
            newMember.setMemberName(memberName);
            newMember.setPhone("Not Found");
            int insertResult = memberMapper.insertMember(newMember);
        }
        return newMember;
    }

    private SocialMemberDTO getSocialMember(String accessToken) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Access-Control-Allow-Origin", "*");

        HttpEntity<MultiValueMap<String, String>> socialMemberRequest = new HttpEntity<>(headers);
        System.out.println("socialMemberRequest = " + socialMemberRequest);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                socialMemberRequest,
                String.class
        );
        System.out.println("response = " + response);

        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        System.out.println("jsonNode = " + jsonNode);

        String memberId = jsonNode.get("id").asText();
        String email = jsonNode.get("kakao_account").get("email").asText();
        String memberName = jsonNode.get("kakao_account").get("profile").get("nickname").asText();

        return new SocialMemberDTO(memberId, email, memberName);

    }


}

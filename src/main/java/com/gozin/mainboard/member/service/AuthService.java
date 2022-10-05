package com.gozin.mainboard.member.service;

import com.gozin.mainboard.exception.LoginFailedException;
import com.gozin.mainboard.jwt.TokenProvider;
import com.gozin.mainboard.member.dao.MemberMapper;
import com.gozin.mainboard.member.dto.MemberDTO;
import com.gozin.mainboard.member.dto.TokenDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public AuthService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Transactional
    public MemberDTO join(MemberDTO memberDTO) {
        // 이메일 중복 여부 추가
        memberDTO.setMemberPwd(passwordEncoder.encode(memberDTO.getMemberPwd()));
        int result = memberMapper.insertMember(memberDTO);
        return memberDTO;
    }

    @Transactional
    public TokenDTO login(MemberDTO memberDTO) {
        MemberDTO member = memberMapper.findByMemberId(memberDTO.getMemberId())
                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호 입니다."));

        System.out.println("member = " + member);
        if(!passwordEncoder.matches(memberDTO.getMemberPwd(), member.getMemberPwd())){
            throw new LoginFailedException("잘못된 아이디 또는 비밀번호 입니다.");
        }

        TokenDTO token = tokenProvider.generateTokenDTO(member);

        return token;
    }
}

package com.gozin.mainboard.member.service;

import com.gozin.mainboard.exception.DuplicatedMemberIdException;
import com.gozin.mainboard.exception.FullInputMemberInfoException;
import com.gozin.mainboard.exception.LoginFailedException;
import com.gozin.mainboard.jwt.TokenProvider;
import com.gozin.mainboard.member.dao.MemberMapper;
import com.gozin.mainboard.member.dto.MemberDTO;
import com.gozin.mainboard.member.dto.TokenDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : AuthService
 * Comment: 권한 서비스
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-01         이유리           최초 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */
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

        if(memberMapper.findById(memberDTO.getMemberId()) != null ){
            throw new DuplicatedMemberIdException("이미 가입된 아이디입니다!");
        }

        if(memberMapper.findByEmail(memberDTO.getEmail()) != null ){
            throw new DuplicatedMemberIdException("이미 가입된 이메일입니다!");
        }

        if(memberDTO.getMemberId() == "" || memberDTO.getMemberPwd() == "" || memberDTO.getEmail() == "" || memberDTO.getPhone() == ""){
            throw new FullInputMemberInfoException("필수 정보를 모두 입력해주세요");
        }

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

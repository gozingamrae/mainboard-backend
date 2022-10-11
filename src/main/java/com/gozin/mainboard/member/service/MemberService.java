package com.gozin.mainboard.member.service;

import com.gozin.mainboard.exception.ChangePwdFailedException;
import com.gozin.mainboard.jwt.TokenProvider;
import com.gozin.mainboard.member.dao.MemberMapper;
import com.gozin.mainboard.member.dto.ChangePwdDTO;
import com.gozin.mainboard.member.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : MemberService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-08         이유리           최초 생성
 * 2022-10-08         이유리           update 메소드 생성
 * 2022-10-10         이유리           회원탈퇴 메소드 생성
 * 2022-10-10         이유리           회원 아이디 찾기 메소드 생성
 * 2022-10-11         이유리           회원 비밀번호 수정 메소드 생성
 * 2022-10-12         이유리           회원 아이디 찾기 메소드 수정
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }


    @Transactional
    public int update(MemberDTO memberDTO) {
        int result = memberMapper.updateMember(memberDTO);

        return result;
    }

    public MemberDTO findMemberById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);
        return member;
    }

    public int delete(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        int result = memberMapper.deleteMember(memberId);
        return result;
    }

    public String findId(MemberDTO memberDTO) {
        String memberId = memberMapper.findId(memberDTO);
        return memberId;
    }
    @Transactional
    public int findPwd(ChangePwdDTO changePwdDTO) {

        MemberDTO member = memberMapper.findByMemberId(changePwdDTO.getMemberId())
                .orElseThrow(() -> new ChangePwdFailedException("회원 비밀번호 변경을 진행할 수 없습니다. "));

        if(!passwordEncoder.matches(changePwdDTO.getOriginPwd(), member.getMemberPwd())){
            throw new ChangePwdFailedException("현재 비밀번호가 일치하지 않습니다.");
        }

        changePwdDTO.setMemberPwd(passwordEncoder.encode(changePwdDTO.getMemberPwd()));
        int result = memberMapper.changePwd(changePwdDTO);

        return result;
    }
}

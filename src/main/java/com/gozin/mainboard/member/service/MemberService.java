package com.gozin.mainboard.member.service;

import com.gozin.mainboard.member.dao.MemberMapper;
import com.gozin.mainboard.member.dto.MemberDTO;
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
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional
    public int update(MemberDTO memberDTO) {
        int result = memberMapper.updateMember(memberDTO);

        return result;
    }

    public MemberDTO findMemberById(String memberId) {
        MemberDTO member = memberMapper.findById(memberId);
        return member;
    }

    public int delete(String memberId) {
        int result = memberMapper.deleteMember(memberId);

        return result;
    }
}

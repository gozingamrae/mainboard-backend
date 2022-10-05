package com.gozin.mainboard.member.dao;

import com.gozin.mainboard.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public MemberDTO findByEmail(String email);

    public int insertMember(MemberDTO memberDTO);

    Optional<MemberDTO> findByMemberId(String memberId);
}

package com.gozin.mainboard.member.dao;

import com.gozin.mainboard.member.dto.BlacklistDTO;
import com.gozin.mainboard.member.dto.ChangePwdDTO;
import com.gozin.mainboard.member.dto.ConditionDTO;
import com.gozin.mainboard.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;
/**
 * <pre>
 * Class : MemberMapper
 * Comment:
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
@Mapper
public interface MemberMapper {
    public MemberDTO findByEmail(String email);

    public int insertMember(MemberDTO memberDTO);

    Optional<MemberDTO> findByMemberId(String memberId);

    MemberDTO findById(String memberId);

    int updateMember(MemberDTO memberDTO);

    int deleteMember(String memberId);

    String findId(MemberDTO memberDTO);

    int changePwd(ChangePwdDTO changePwdDTO);

    List<MemberDTO> findMemberAll();

    int registBlacklist(BlacklistDTO blacklistDTO);

    List<BlacklistDTO> selectBlacklist();

    List<MemberDTO> selectMembersByCondition(ConditionDTO condition);
}

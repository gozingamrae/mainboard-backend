package com.gozin.mainboard.member.dto;

import java.sql.Date;

/**
 * <pre>
 * Class : ConditionDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-13         이유리           최초 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */
public class ConditionDTO {

    private String memberName;
    private String memberId;
    private java.sql.Date joinDate;
    private String withdrawalMember;

    public ConditionDTO(){}

    public ConditionDTO(String memberName, String memberId, Date joinDate, String withdrawalMember) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.joinDate = joinDate;
        this.withdrawalMember = withdrawalMember;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getWithdrawalMember() {
        return withdrawalMember;
    }

    public void setWithdrawalMember(String withdrawalMember) {
        this.withdrawalMember = withdrawalMember;
    }

    @Override
    public String toString() {
        return "ConditionDTO{" +
                "memberName='" + memberName + '\'' +
                ", memberId='" + memberId + '\'' +
                ", joinDate=" + joinDate +
                ", withdrawalMember='" + withdrawalMember + '\'' +
                '}';
    }
}

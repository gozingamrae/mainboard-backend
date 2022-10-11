package com.gozin.mainboard.member.dto;

/**
 * <pre>
 * Class : SocialMemberDTO
 * Comment: 소셜 멤버 DTO
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-04         이유리           최초 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */
public class SocialMemberDTO {
    private String memberId;
    private String email;

    private String memberName;

    public SocialMemberDTO() {}

    public SocialMemberDTO(String memberId, String email, String memberName) {
        this.memberId = memberId;
        this.email = email;
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "SocialMemberDTO{" +
                "memberId='" + memberId + '\'' +
                ", email='" + email + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }

}

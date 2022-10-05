package com.gozin.mainboard.member.dto;

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

package com.gozin.mainboard.member.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * <pre>
 * Class : MemberDTO
 * Comment:
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-01         이유리          최초 생성
 * 2022-10-07         이유리          memberRole 컬럼 추가
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */

public class MemberDTO implements UserDetails {

    private Long memberCode;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String email;
    private String phone;
    private String gender;
    private String job;
    private String birthDateTime;
    private String loginLock;
    private String joinDate;
    private String withdrawalMember;
    private Long holdingPoint;
    private String memberRole;

    public MemberDTO() {}

    public MemberDTO(Long memberCode, String memberId, String memberPwd, String memberName, String email, String phone, String gender, String job, String birthDateTime, String loginLock, String joinDate, String withdrawalMember, Long holdingPoint, Long addressCode, String memberRole, Collection<? extends GrantedAuthority> authorities) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.job = job;
        this.birthDateTime = birthDateTime;
        this.loginLock = loginLock;
        this.joinDate = joinDate;
        this.withdrawalMember = withdrawalMember;
        this.holdingPoint = holdingPoint;
        this.memberRole = memberRole;
        this.authorities = authorities;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthDateTime() {
        return birthDateTime;
    }

    public void setBirthDateTime(String birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    public String getLoginLock() {
        return loginLock;
    }

    public void setLoginLock(String loginLock) {
        this.loginLock = loginLock;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getWithdrawalMember() {
        return withdrawalMember;
    }

    public void setWithdrawalMember(String withdrawalMember) {
        this.withdrawalMember = withdrawalMember;
    }

    public Long getHoldingPoint() {
        return holdingPoint;
    }

    public void setHoldingPoint(Long holdingPoint) {
        this.holdingPoint = holdingPoint;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.memberPwd;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", birthDateTime=" + birthDateTime +
                ", loginLock='" + loginLock + '\'' +
                ", joinDate=" + joinDate +
                ", withdrawalMember='" + withdrawalMember + '\'' +
                ", holdingPoint=" + holdingPoint +
                ", memberRole='" + memberRole + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}

package com.gozin.mainboard.member.dto;

import java.util.Date;

/**
 * <pre>
 * Class : BlacklistDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-12         이유리           최초 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */
public class BlacklistDTO {

    private int blacklistCode;
    private String memberId;
    private Date registrationDate;
    private Date terminationDate;
    private String description;

    public BlacklistDTO(){}

    public BlacklistDTO(int blacklistCode, String memberId, Date registrationDate, Date terminationDate, String description) {
        this.blacklistCode = blacklistCode;
        this.memberId = memberId;
        this.registrationDate = registrationDate;
        this.terminationDate = terminationDate;
        this.description = description;
    }

    public int getBlacklistCode() {
        return blacklistCode;
    }

    public void setBlacklistCode(int blacklistCode) {
        this.blacklistCode = blacklistCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BlacklistDTO{" +
                "blacklistCode=" + blacklistCode +
                ", memberId='" + memberId + '\'' +
                ", registrationDate=" + registrationDate +
                ", terminationDate=" + terminationDate +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.gozin.mainboard.exception;

/**
 * <pre>
 * Class : DuplicatedMemberIdException
 * Comment: 회원가입 시 중복된 아이디, 이메일이 입력되었을 때 출력할 오류
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-06         이유리           최초 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */
public class DuplicatedMemberIdException extends RuntimeException {

    public DuplicatedMemberIdException() {
        super();
    }
    public DuplicatedMemberIdException(String s) {
        super(s);
    }
    public DuplicatedMemberIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedMemberIdException(Throwable cause) {
        super(cause);
    }
}


package com.gozin.mainboard.exception;
/**
 * <pre>
 * Class : FullInputMemberInfoException
 * Comment: 회원가입 시 필수정보가 모두 입력되지 않았을 때 출력할 오류
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

public class FullInputMemberInfoException extends RuntimeException {

    public FullInputMemberInfoException() {
        super();
    }
    public FullInputMemberInfoException(String s) { super(s);}

    public FullInputMemberInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullInputMemberInfoException(Throwable cause) {
        super(cause);
    }
}

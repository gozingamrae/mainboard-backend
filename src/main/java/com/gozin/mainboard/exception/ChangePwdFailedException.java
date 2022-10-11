package com.gozin.mainboard.exception;

/**
 * <pre>
 * Class : ChangePwdFailedException
 * Comment: 비밀번호 변경 시 에러 예외처리
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-11         이유리           최초 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */
public class ChangePwdFailedException extends RuntimeException {
    public ChangePwdFailedException() {
        super();
    }
    public ChangePwdFailedException(String s) {
        super(s);
    }
    public ChangePwdFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangePwdFailedException(Throwable cause) {
        super(cause);
    }
}

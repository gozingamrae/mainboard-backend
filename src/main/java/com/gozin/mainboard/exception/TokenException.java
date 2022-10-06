package com.gozin.mainboard.exception;

/**
 * <pre>
 * Class : TokenException
 * Comment: 토큰 예외처리
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

public class TokenException extends RuntimeException{

    public TokenException() {
        super();
    }
    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(Throwable cause) {
        super(cause);
    }
}

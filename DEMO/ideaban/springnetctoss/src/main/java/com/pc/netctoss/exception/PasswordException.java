package com.pc.netctoss.exception;

/**
 * 密码错误异常
 * @author: Peter
 * @date: 2020/12/10 19:46
 */
public class PasswordException extends RuntimeException {

    public PasswordException() {
        super();
    }

    public PasswordException(String message) {
        super(message);
    }
}

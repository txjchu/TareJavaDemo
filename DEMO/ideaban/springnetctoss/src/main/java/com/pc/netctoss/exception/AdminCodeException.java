package com.pc.netctoss.exception;

/**
 * 账号错误异常
 * @author: Peter
 * @date: 2020/12/10 19:45
 */
public class AdminCodeException extends RuntimeException {

    public AdminCodeException() {
        super();
    }

    public AdminCodeException(String message) {
        super(message);
    }
}

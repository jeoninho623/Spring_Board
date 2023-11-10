package com.koreait.commons.exceptions;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    private HttpStatus status;

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);    // 500에러
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    private HttpStatus getStatus() {
        return status;
    }
}
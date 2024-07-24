package com.thahawuru_wallet.application.exception;

public class RequestForbiddenException extends RuntimeException {
    public RequestForbiddenException(String message) {
        super(message);
    }
}

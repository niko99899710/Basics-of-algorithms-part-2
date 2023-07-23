package com.example.basicsofalgorithmspart2.exception;

public class NotFindException extends RuntimeException{
    public NotFindException() {
    }

    public NotFindException(String message) {
        super(message);
    }

    public NotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFindException(Throwable cause) {
        super(cause);
    }

    public NotFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

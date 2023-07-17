package com.example.basicsofalgorithmspart2.exception;

public class DontTrueSizeIndexException extends RuntimeException {
    public DontTrueSizeIndexException() {
    }

    public DontTrueSizeIndexException(String message) {
        super(message);
    }

    public DontTrueSizeIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public DontTrueSizeIndexException(Throwable cause) {
        super(cause);
    }

    public DontTrueSizeIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

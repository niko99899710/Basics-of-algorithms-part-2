package com.example.basicsofalgorithmspart2.exception;

public class FullSizeItemException extends RuntimeException{
    public FullSizeItemException() {
    }

    public FullSizeItemException(String message) {
        super(message);
    }

    public FullSizeItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullSizeItemException(Throwable cause) {
        super(cause);
    }

    public FullSizeItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

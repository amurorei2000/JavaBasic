package com.supercoding.chapter_47;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {

    }

    public DivideByZeroException(String message) {
        super(message);
    }

    public DivideByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivideByZeroException(Throwable cause) {
        super(cause);
    }
}

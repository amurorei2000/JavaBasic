package com.supercoding.chapter_47;

public class InvalidOperatorException extends Exception {
    public InvalidOperatorException() {

    }

    public InvalidOperatorException(String message) {
        super(message);
    }

    public InvalidOperatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperatorException(Throwable cause) {
        super(cause);
    }
}

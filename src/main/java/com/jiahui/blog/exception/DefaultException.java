package com.jiahui.blog.exception;

public class DefaultException extends RuntimeException{
    public DefaultException() {
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(Throwable cause) {
        super(cause);
    }
}

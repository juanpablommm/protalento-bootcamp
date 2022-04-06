package com.educacionit.exception;

@SuppressWarnings("serial")
public class ServicesException extends Exception{

    public ServicesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicesException(String message) {
        super(message);
    }
}

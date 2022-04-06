package com.educacionit.exception;

@SuppressWarnings("serial")
public class GenericException extends Exception{

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericException(String message) {
        super(message);
    }
}

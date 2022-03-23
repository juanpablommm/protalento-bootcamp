package com.educacionit.exceptions;

@SuppressWarnings("serial")
public class GenericExceptions extends Exception{

    public GenericExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericExceptions(String message) {
        super(message);
    }
}

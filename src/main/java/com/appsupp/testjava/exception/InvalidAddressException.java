package com.appsupp.testjava.exception;

public class InvalidAddressException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "Invalid address";

    public InvalidAddressException() {
        super(DEFAULT_MESSAGE);
    }
};

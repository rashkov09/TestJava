package com.appsupp.testjava.exception;

public class InvalidCityException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Invalid name";

    public InvalidCityException() {
        super(DEFAULT_MESSAGE);
    }
}

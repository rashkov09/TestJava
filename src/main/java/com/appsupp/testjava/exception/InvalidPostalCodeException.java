package com.appsupp.testjava.exception;

public class InvalidPostalCodeException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Invalid postal code";

    public InvalidPostalCodeException() {
        super(DEFAULT_MESSAGE);
    }
}

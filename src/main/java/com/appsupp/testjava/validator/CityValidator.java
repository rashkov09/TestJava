package com.appsupp.testjava.validator;

import java.util.regex.Pattern;

public class CityValidator implements Validator{
    private static final String CITY_REGEX = "^[A-Z][a-zA-Z]{5,}$";

    @Override
    public boolean isValid(String StringValue) {
        return Pattern.matches(CITY_REGEX, StringValue);
    }
}

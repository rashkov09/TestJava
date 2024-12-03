package com.appsupp.testjava.validator;

import java.util.regex.Pattern;

public class PostalCodeValidator implements Validator {
    private static  final String POSTAL_CODE_REGEX = "^[0-9]{5}$";
    @Override
    public boolean isValid(String postalCode) {
        return Pattern.matches(POSTAL_CODE_REGEX, postalCode);
    }
}

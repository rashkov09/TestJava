package com.appsupp.testjava.validator;

import java.util.regex.Pattern;

public class PostalCodeValidator implements Validator {
    /**
     * The regular expression pattern used to validate postal codes.
     * The pattern consists of the following elements:
     *   ^     asserts the start of the line
     *   [0-9] matches any digit (0-9)
     *   {5}   specifies that the preceding element should be matched exactly 5 times
     *   $     asserts the end of the line
     * In summary, this pattern matches any string that consists of exactly 5 digits and has no spaces.
     */
    private static  final String POSTAL_CODE_REGEX = "^[0-9]{5}$";
    @Override
    public boolean isValid(String postalCode) {
        return Pattern.matches(POSTAL_CODE_REGEX, postalCode);
    }
}

package com.appsupp.testjava.validator;

import java.util.regex.Pattern;

public class NameValidator implements Validator {
    private static final String NAME_REGEX = "^[A-Z][a-zA-Z]{1,}$";
    /**
     * Checks whether the input string is a valid name according to the predefined regex pattern.
     * Only latin letters, uppercase and lowercase are allowed.
     * @param StringValue the input string to be validated
     * @return true if the input string matches the regex pattern, false otherwise
     */

    @Override
    public boolean isValid(String StringValue) {
        return Pattern.matches(NAME_REGEX, StringValue);
    }
}

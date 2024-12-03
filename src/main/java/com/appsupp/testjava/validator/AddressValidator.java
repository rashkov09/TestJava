package com.appsupp.testjava.validator;

import java.util.regex.Pattern;

public class AddressValidator implements Validator {
   private static final String ADDRESS_REGEX = "^[a-zA-Z0-9\\s,.-]+$";

    @Override
    public boolean isValid(String StringValue) {
        return Pattern.matches(ADDRESS_REGEX, StringValue);
    }


}

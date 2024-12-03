package com.appsupp.testjava.service;

import com.appsupp.testjava.exception.InvalidAddressException;
import com.appsupp.testjava.exception.InvalidCityException;
import com.appsupp.testjava.exception.InvalidNameException;
import com.appsupp.testjava.exception.InvalidPostalCodeException;
import com.appsupp.testjava.model.PersonInformationRequest;
import com.appsupp.testjava.validator.*;
import org.springframework.stereotype.Service;

@Service
public class PersonInformationValidationService {
    private final Validator addressValidator;
    private final Validator nameValidator;
    private final Validator postalCodeValidator;
    private final Validator cityValidator;

    public PersonInformationValidationService() {
        this.cityValidator = new CityValidator();
        this.addressValidator = new AddressValidator();
        this.nameValidator = new NameValidator();
        this.postalCodeValidator = new PostalCodeValidator();
    }

    public boolean validate(PersonInformationRequest personInformationRequest) {

        if (!addressValidator.isValid(personInformationRequest.getStreetAddress())) {
            throw new InvalidAddressException();
        }

        if (!nameValidator.isValid(personInformationRequest.getFirstName())) {
            throw new InvalidNameException();
        }
        if (!nameValidator.isValid(personInformationRequest.getLastName())) {
            throw new InvalidNameException();
        }
        if (!cityValidator.isValid(personInformationRequest.getCity())) {
            throw new InvalidCityException();
        }
        if(!postalCodeValidator.isValid(personInformationRequest.getPostalCode())) {
            throw new InvalidPostalCodeException();
        }

        return true;
    }
}

package com.appsupp.testjava.controller;


import com.appsupp.testjava.model.PersonInformationRequest;
import com.appsupp.testjava.service.PersonInformationValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final PersonInformationValidationService personInformationValidationService;

    @Autowired
    public MainController(PersonInformationValidationService personInformationValidationService) {
        this.personInformationValidationService = personInformationValidationService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        return "index";
    }

    @PostMapping("/")
    public ResponseEntity<String> processForm(
            @RequestParam("firstName") String firstName,
    @RequestParam("lastName") String lastName,
    @RequestParam("streetAddress") String streetAddress,
    @RequestParam("postalCode") String postalCode,
    @RequestParam("city") String city,
    @RequestParam("country") String country) {
        try {
            PersonInformationRequest personInformationRequest = new PersonInformationRequest(firstName, lastName, streetAddress, postalCode, city, country);
            if (personInformationValidationService.validate(personInformationRequest)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Form submitted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid form data");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
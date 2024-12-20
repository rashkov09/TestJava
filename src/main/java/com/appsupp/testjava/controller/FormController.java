package com.appsupp.testjava.controller;


import com.appsupp.testjava.model.PersonInformationRequest;
import com.appsupp.testjava.service.PersonInformationValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    private final PersonInformationValidationService personInformationValidationService;


    @Autowired
    public FormController(PersonInformationValidationService personInformationValidationService) {
        this.personInformationValidationService = personInformationValidationService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        return new ModelAndView("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/")
    public ModelAndView processForm(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("streetAddress") String streetAddress,
            @RequestParam("postalCode") String postalCode,
            @RequestParam("city") String city,
            @RequestParam("country") String country){

        try {
            PersonInformationRequest personInformationRequest = new PersonInformationRequest(firstName, lastName, streetAddress, postalCode, city, country);
            if (personInformationValidationService.validate(personInformationRequest)) {
                return new ModelAndView("success", HttpStatus.OK);
            } else {
                return new ModelAndView("error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
             return new ModelAndView("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
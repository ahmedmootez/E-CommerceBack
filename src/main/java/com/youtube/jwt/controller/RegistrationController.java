package com.youtube.jwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.youtube.jwt.entity.RegistrationRequest;
import com.youtube.jwt.entity.RegistrationResponse;
import com.youtube.jwt.service.RegistrationService;

@RestController
@RequestMapping(path = "registration")
public class RegistrationController {

	@Autowired
    private  RegistrationService registrationService;

    @PostMapping
    public RegistrationResponse register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
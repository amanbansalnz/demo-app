package org.demo.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.demo.core.service.AuthenticationService;
import org.demo.web.model.request.LoginRequest;
import org.demo.web.model.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@Slf4j
public class AuthenticationController {

    @Autowired
    private AuthenticationService authethicationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        log.info("AuthenticationController login");

        String token = authethicationService.authenticate(loginRequest.getMemberName(), loginRequest.getPassword());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);

        log.info("AuthenticationController login response <<<< with loginResponse={}", loginResponse);

        return loginResponse;
    }
}

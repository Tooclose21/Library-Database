package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.filters.LoginForm;
import com.example.technologiesieciowe.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Login controller.
 */
@RestController
@CrossOrigin
public class LoginController {
    private final LoginService loginService;

    /**
     * Instantiates a new Login controller.
     *
     * @param loginService the login service
     */
    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    /**
     * Login response entity.
     *
     * @param loginForm the login form
     * @return the response entity
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm){
        String token = loginService.login(loginForm);
        return ResponseEntity.ofNullable(token);
    }
}

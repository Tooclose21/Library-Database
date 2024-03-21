package com.example.technologiesieciowe.controller;

import com.example.technologiesieciowe.filters.LoginForm;
import com.example.technologiesieciowe.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm){
        String token = loginService.login(loginForm);
        return ResponseEntity.ofNullable(token);
    }
}

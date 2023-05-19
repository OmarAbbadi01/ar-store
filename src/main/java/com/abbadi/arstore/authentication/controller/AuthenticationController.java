package com.abbadi.arstore.authentication.controller;

import com.abbadi.arstore.authentication.model.AuthenticationResponse;
import com.abbadi.arstore.authentication.model.LoginRequest;
import com.abbadi.arstore.authentication.model.CustomerRegisterRequest;
import com.abbadi.arstore.authentication.service.AuthenticationService;
import com.abbadi.arstore.common.validation.OnCreate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register/customer")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid @Validated(OnCreate.class) CustomerRegisterRequest request) {
        return ResponseEntity.ok(service.registerCustomer(request));
    }

//    @PostMapping("/register/store")
//    public ResponseEntity<AuthenticationResponse> registerStore() {
//
//    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }
}

package com.abbadi.arstore.authentication.controller;

import com.abbadi.arstore.authentication.config.Security;
import com.abbadi.arstore.authentication.model.Token;
import com.abbadi.arstore.authentication.model.LoginRequest;
import com.abbadi.arstore.authentication.model.CustomerRegisterRequest;
import com.abbadi.arstore.authentication.service.AuthenticationService;
import com.abbadi.arstore.common.validation.OnCreate;
import jakarta.servlet.http.HttpServletResponse;
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

    private final Security security;

    @PostMapping("/register/customer")
    public ResponseEntity<Object> register(@RequestBody @Valid @Validated(OnCreate.class) CustomerRegisterRequest request,
                                           HttpServletResponse response) {
        Token token = service.registerCustomer(request);
        response.setHeader(security.getJwtTokenHeaderName(), token.getValue());
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/register/store")
//    public ResponseEntity<AuthenticationResponse> registerStore() {
//
//    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginRequest request, HttpServletResponse response) {
        Token token = service.login(request);
        response.setHeader(security.getJwtTokenHeaderName(), token.getValue());
        return ResponseEntity.ok().build();
    }
}

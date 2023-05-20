package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.authentication.config.Security;
import com.abbadi.arstore.authentication.model.*;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    private final Security security;

    @PostMapping("/register/customer")
    public ResponseEntity<RegisterationResponse> register(@RequestBody @Valid CustomerRegisterRequest request,
                                                          HttpServletResponse httpServletResponse) {
        RegisterationResponse registerationResponse = service.registerCustomer(request);
        Token token = registerationResponse.getToken();
        httpServletResponse.setHeader(security.getJwtTokenHeaderName(), token.getValue());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registerationResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/register/store")
    public ResponseEntity<RegisterationResponse> registerStore(@RequestBody @Valid StoreReigsterRequest request,
                                                               HttpServletResponse httpServletResponse) {
        RegisterationResponse registerationResponse = service.registerStore(request);
        Token token = registerationResponse.getToken();
        httpServletResponse.setHeader(security.getJwtTokenHeaderName(), token.getValue());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registerationResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/login")
    public ResponseEntity<RegisterationResponse> login(@RequestBody @Valid LoginRequest request, HttpServletResponse response) {
        Token token = service.login(request);
        response.setHeader(security.getJwtTokenHeaderName(), token.getValue());
        return ResponseEntity.ok().build();
    }
}

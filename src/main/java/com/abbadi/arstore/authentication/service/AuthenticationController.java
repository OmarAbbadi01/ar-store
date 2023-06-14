package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.common.config.SecurityConfigProperties;
import com.abbadi.arstore.authentication.model.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    private final SecurityConfigProperties securityConfigProperties;

    @PostMapping("/register/customer")
    public ResponseEntity<RegistrationResponse> register(@RequestBody @Valid CustomerRegisterRequest request,
                                                         HttpServletResponse httpServletResponse) {
        RegistrationResponse registrationResponse = service.registerCustomer(request);
        Token token = registrationResponse.getToken();
        httpServletResponse.setHeader(securityConfigProperties.getJwtTokenHeaderName(), token.getValue());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registrationResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/register/store")
    public ResponseEntity<RegistrationResponse> registerStore(@RequestBody @Valid StoreReigsterRequest request,
                                                              HttpServletResponse httpServletResponse) {
        RegistrationResponse registrationResponse = service.registerStore(request);
        Token token = registrationResponse.getToken();
        httpServletResponse.setHeader(securityConfigProperties.getJwtTokenHeaderName(), token.getValue());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(registrationResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/login")
    public ResponseEntity<RegistrationResponse> login(@RequestBody @Valid LoginRequest request, HttpServletResponse response) {
        Token token = service.login(request);
        response.setHeader(securityConfigProperties.getJwtTokenHeaderName(), token.getValue());
        return ResponseEntity.ok().build();
    }
}

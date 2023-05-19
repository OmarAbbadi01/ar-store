package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.authentication.model.AuthenticationResponse;
import com.abbadi.arstore.authentication.model.LoginRequest;
import com.abbadi.arstore.authentication.model.CustomerRegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse registerCustomer(CustomerRegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}

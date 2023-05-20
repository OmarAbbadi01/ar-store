package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.authentication.model.Token;
import com.abbadi.arstore.authentication.model.CustomerRegisterRequest;
import com.abbadi.arstore.authentication.model.LoginRequest;

public interface AuthenticationService {

    Token registerCustomer(CustomerRegisterRequest request);

    Token login(LoginRequest request);
}

package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.authentication.model.*;

public interface AuthenticationService {

    RegistrationResponse registerCustomer(CustomerRegisterRequest request);

    RegistrationResponse registerStore(StoreReigsterRequest request);

    Token login(LoginRequest request);
}

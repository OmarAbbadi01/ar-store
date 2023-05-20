package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.authentication.model.*;

public interface AuthenticationService {

    RegisterationResponse registerCustomer(CustomerRegisterRequest request);

    RegisterationResponse registerStore(StoreReigsterRequest request);

    Token login(LoginRequest request);
}

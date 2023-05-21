package com.abbadi.arstore.authentication.model;

import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.customer.model.CustomerRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CustomerRegisterRequest {

    @Email(message = "Not Valid Email", groups = OnCreate.class)
    @NotNull(message = "Email Can't Be Null", groups = OnCreate.class)
    String email;

    @NotNull(message = "Password Can't Be Null", groups = OnCreate.class)
    String password;

    @NotNull(message = "Customer Info Missing", groups = OnCreate.class)
    CustomerRequest customer;

}
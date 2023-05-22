package com.abbadi.arstore.authentication.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class LoginRequest {

    @Email(message = "Not an email")
    @NotNull(message = "Email Can't Be Null")
    String email;

    @NotNull(message = "Password Can't Be Null")
    String password;
}

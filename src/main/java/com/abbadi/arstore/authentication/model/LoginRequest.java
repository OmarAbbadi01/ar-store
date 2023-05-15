package com.abbadi.arstore.authentication.model;

import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Value
public class LoginRequest {

    @Email
    @NotNull(message = "Email Can't Be Null")
    String email;

    @NotNull(message = "Password Can't Be Null")
    String password;
}

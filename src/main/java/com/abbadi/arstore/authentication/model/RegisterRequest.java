package com.abbadi.arstore.authentication.model;

import com.abbadi.arstore.user.model.UserType;
import lombok.Value;

@Value
public class RegisterRequest {

    String email;

    String password;

    UserType userType;
}

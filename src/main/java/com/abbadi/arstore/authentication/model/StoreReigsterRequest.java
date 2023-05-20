package com.abbadi.arstore.authentication.model;

import com.abbadi.arstore.store.model.StoreRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class StoreReigsterRequest {

    @Email(message = "Not Valid Email")
    @NotNull(message = "Email Can't Be Null")
    String email;

    @NotNull(message = "Password Can't Be Null")
    String password;

    @NotNull(message = "Store Info Missing")
    StoreRequest store;
}

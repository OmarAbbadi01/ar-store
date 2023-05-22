package com.abbadi.arstore.authentication.model;

import com.abbadi.arstore.store.model.StoreRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class StoreReigsterRequest {

    @Email(message = "Not Valid Email")
    @NotNull(message = "Email Can't Be Null")
    String email;

    @NotNull(message = "Password Can't Be Null")
    @Size(min = 8, message = "Password should be at least 8 characters")
    String password;

    @NotNull(message = "Store Info Missing")
    @Valid
    StoreRequest store;
}

package com.abbadi.arstore.account.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountResponse implements GenericResponse<Long> {

    Long id;

    String username;

    String password;

    AccountType accountType;

}
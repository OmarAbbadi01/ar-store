package com.abbadi.arstore.account.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import lombok.Value;

@Value
public class AccountRequest implements GenericRequest<Long> {

    Long id;

    String username;

    String password;

    AccountType accountType;

}

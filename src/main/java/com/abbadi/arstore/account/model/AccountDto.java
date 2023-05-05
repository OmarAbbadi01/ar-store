package com.abbadi.arstore.account.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto implements GenericDto<String> {

    private String username;

    private String email;

    private String password;

    private AccountType accountType;

    @Override
    public String getId() {
        return this.username;
    }
}

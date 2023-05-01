package com.abbadi.arstore.account.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto implements GenericDto<Long> {

    private Long id;

    private String username;

    private String password;

    private AccountType accountType;

}

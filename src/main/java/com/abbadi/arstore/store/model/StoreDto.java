package com.abbadi.arstore.store.model;

import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StoreDto implements GenericDto<Long> {

    private Long id;

    private String name;

    private String phoneNumber;

    private AccountDto accountDto;
}

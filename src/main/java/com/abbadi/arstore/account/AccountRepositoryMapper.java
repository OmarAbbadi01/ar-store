package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryMapper implements GenericRepositoryMapper<Long, Account, AccountDto> {

    @Override
    public AccountDto toDto(Account entity) {
        return AccountDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .accountType(entity.getAccountType())
                .build();
    }

    @Override
    public Account toEntity(AccountDto dto) {
        return Account.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .accountType(dto.getAccountType())
                .build();
    }
}

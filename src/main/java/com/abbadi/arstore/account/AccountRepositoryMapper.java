package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryMapper implements GenericRepositoryMapper<String, Account, AccountDto> {

    @Override
    public AccountDto toDto(Account entity) {
        return AccountDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .accountType(entity.getAccountType())
                .build();
    }

    @Override
    public Account toEntity(AccountDto dto) {
        return Account.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .accountType(dto.getAccountType())
                .build();
    }
}

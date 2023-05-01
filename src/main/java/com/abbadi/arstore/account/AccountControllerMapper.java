package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.account.model.AccountRequest;
import com.abbadi.arstore.account.model.AccountResponse;
import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountControllerMapper implements GenericControllerMapper<Long, AccountDto, AccountRequest, AccountResponse> {

    @Override
    public AccountDto toDto(AccountRequest request) {
        return AccountDto.builder()
                .id(request.getId())
                .username(request.getUsername())
                .password(request.getPassword())
                .accountType(request.getAccountType())
                .build();
    }

    @Override
    public AccountResponse toResponse(AccountDto dto) {
        return AccountResponse.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .accountType(dto.getAccountType())
                .build();
    }
}

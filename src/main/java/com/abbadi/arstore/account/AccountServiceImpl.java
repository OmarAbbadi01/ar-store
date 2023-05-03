package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends GenericServiceImpl<Long, AccountDto> implements AccountService {

    private final AccountRepository repository;


    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

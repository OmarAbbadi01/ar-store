package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericService;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends GenericServiceImpl<Long, AccountDto, Account> implements AccountService {

    private final AccountRepository repository;

    private final AccountRepositoryMapper mapper;

    public AccountServiceImpl(AccountRepository repository, AccountRepositoryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}

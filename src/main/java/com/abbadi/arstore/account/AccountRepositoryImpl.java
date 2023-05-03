package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl<Long, Account, AccountDto> implements AccountRepository {

    private final AccountDao dao;

    private final AccountRepositoryMapper mapper;


    public AccountRepositoryImpl(AccountDao dao, AccountRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }
}

package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl<String, Account, AccountDto> implements AccountRepository {

    private final AccountDao dao;

    private final AccountRepositoryMapper mapper;


    public AccountRepositoryImpl(AccountDao dao, AccountRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public AccountDto findAccountByStoreId(Long storeId) {
        return mapper.toDto(dao.findAccountByStoreId(storeId));
    }
}

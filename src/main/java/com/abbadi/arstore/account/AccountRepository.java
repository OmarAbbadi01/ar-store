package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericRepository;

public interface AccountRepository extends GenericRepository<String, AccountDto> {

    AccountDto findAccountByStoreId(Long storeId);

}

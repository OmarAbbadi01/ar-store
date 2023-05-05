package com.abbadi.arstore.store;

import com.abbadi.arstore.account.AccountRepository;
import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.store.model.StoreDto;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl extends GenericServiceImpl<Long, StoreDto> implements StoreService {

    private final StoreRepository repository;

    private final AccountRepository accountRepository;

    public StoreServiceImpl(StoreRepository repository, AccountRepository accountRepository) {
        super(repository);
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    @Override
    protected StoreDto beforeUpdate(StoreDto dto) {
        AccountDto accountDto = accountRepository.findAccountByStoreId(dto.getId());
        dto.setAccountDto(accountDto);
        return dto;
    }
}

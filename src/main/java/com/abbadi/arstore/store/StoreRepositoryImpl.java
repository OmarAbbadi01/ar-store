package com.abbadi.arstore.store;

import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import com.abbadi.arstore.store.model.Store;
import com.abbadi.arstore.store.model.StoreDto;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepositoryImpl extends GenericRepositoryImpl<Long, Store, StoreDto> implements StoreRepository {

    private final StoreDao dao;

    private final StoreRepositoryMapper mapper;

    public StoreRepositoryImpl(StoreDao dao, StoreRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }
}

package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryImpl extends GenericRepositoryImpl<Long, Address, AddressDto> implements AddressRepository {

    private final AddressDao dao;

    private final AddressRepositoryMapper mapper;


    public AddressRepositoryImpl(AddressDao dao, AddressRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }
}

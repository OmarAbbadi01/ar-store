package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Long, AddressDto, Address> implements AddressService {

    private final AddressRepository repository;

    private final AddressRepositoryMapper mapper;

    public AddressServiceImpl(AddressRepository repository, AddressRepositoryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

}

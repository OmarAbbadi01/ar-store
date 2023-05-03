package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Long, AddressDto> implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
        this.repository = repository;
    }

}

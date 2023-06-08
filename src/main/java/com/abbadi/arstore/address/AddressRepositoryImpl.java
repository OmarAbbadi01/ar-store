package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepositoryImpl extends GenericRepositoryImpl<Long, Address, AddressDto> implements AddressRepository {

    private final AddressDao dao;

    private final AddressRepositoryMapper mapper;


    public AddressRepositoryImpl(AddressDao dao, AddressRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public AddressDto findByCustomerIdAndAddressId(Long customerId, Long addressId) {
        return mapper.toDto(dao.findByCustomerIdAndAddressId(customerId, addressId));
    }

    @Override
    public List<AddressDto> findAllByCustomerId(Long customerId) {
        return dao.findAllByCustomerId(customerId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }


}

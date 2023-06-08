package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericRepository;

import java.util.List;

public interface AddressRepository extends GenericRepository<Long, AddressDto> {

    AddressDto findByCustomerIdAndAddressId(Long customerId, Long addressId);

    List<AddressDto> findAllByCustomerId(Long customerId);

}

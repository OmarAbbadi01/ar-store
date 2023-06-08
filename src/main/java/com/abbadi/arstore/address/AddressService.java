package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericService;

import java.util.List;

public interface AddressService extends GenericService<Long, AddressDto> {

    AddressDto findByCustomerIdAndAddressId(Long customerId, Long addressId);

    List<AddressDto> findAllByCustomerId(Long customerId);

}

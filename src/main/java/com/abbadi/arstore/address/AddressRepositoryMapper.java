package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.customer.CustomerRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressRepositoryMapper extends GenericRepositoryMapper<Long, Address, AddressDto> {

    @Autowired
    @Lazy
    private CustomerRepositoryMapper customerRepositoryMapper;

    @Override
    public AddressDto mapToDto(Address entity) {
        return AddressDto.builder()
                .id(entity.getId())
                .country(entity.getCountry())
                .city(entity.getCity())
                .street(entity.getStreet())
                .zip(entity.getZip())
                .build();
    }

    @Override
    public Address mapToEntity(AddressDto dto) {
        return Address.builder()
                .id(dto.getId())
                .country(dto.getCountry())
                .city(dto.getCity())
                .street(dto.getStreet())
                .zip(dto.getZip())
                .customer(customerRepositoryMapper.toEntity(dto.getCustomerDto()))
                .build();
    }
}

package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressRepositoryMapper implements GenericRepositoryMapper<Long, Address, AddressDto> {

    @Override
    public AddressDto toDto(Address entity) {
        return AddressDto.builder()
                .id(entity.getId())
                .country(entity.getCountry())
                .city(entity.getCity())
                .street(entity.getStreet())
                .zip(entity.getZip())
                .build();
    }

    @Override
    public Address toEntity(AddressDto dto) {
        return Address.builder()
                .id(dto.getId())
                .country(dto.getCountry())
                .city(dto.getCity())
                .street(dto.getStreet())
                .zip(dto.getZip())
                .build();
    }
}

package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressRepositoryMapper extends GenericRepositoryMapper<Long, Address, AddressDto> {

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
                .build();
    }
}

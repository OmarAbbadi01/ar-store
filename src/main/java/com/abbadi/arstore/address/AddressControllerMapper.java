package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.address.model.AddressRequest;
import com.abbadi.arstore.address.model.AddressResponse;
import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressControllerMapper extends GenericControllerMapper<Long, AddressDto, AddressRequest, AddressResponse> {

    @Override
    public AddressDto mapToDto(AddressRequest request) {
        return AddressDto.builder()
                .id(request.getId())
                .country(request.getCountry())
                .city(request.getCity())
                .street(request.getStreet())
                .zip(request.getZip())
                .build();
    }

    @Override
    public AddressResponse mapToResponse(AddressDto dto) {
        return AddressResponse.builder()
                .id(dto.getId())
                .country(dto.getCountry())
                .city(dto.getCity())
                .street(dto.getStreet())
                .zip(dto.getZip())
                .build();
    }
}

package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.address.model.AddressRequest;
import com.abbadi.arstore.address.model.AddressResponse;
import com.abbadi.arstore.customer.model.CustomerDto;
import org.springframework.security.core.context.SecurityContextHolder;

public class AddressControllerMapper {

    public static AddressDto toDto(AddressRequest request) {
        return request != null ?
                AddressDto.builder()
                        .id(request.getId())
                        .country(request.getCountry())
                        .city(request.getCity())
                        .street(request.getStreet())
                        .zip(request.getZip())
                        .customerDto(CustomerDto.builder()
                                .id((Long) SecurityContextHolder.getContext().getAuthentication().getDetails())
                                .build())
                        .build() : null;
    }

    public static AddressResponse toResponse(AddressDto dto) {
        return dto != null ?
                AddressResponse.builder()
                        .id(dto.getId())
                        .country(dto.getCountry())
                        .city(dto.getCity())
                        .street(dto.getStreet())
                        .zip(dto.getZip())
                        .build() : null;
    }
}

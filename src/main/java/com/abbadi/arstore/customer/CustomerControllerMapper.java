package com.abbadi.arstore.customer;

import com.abbadi.arstore.address.AddressControllerMapper;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.customer.model.CustomerRequest;
import com.abbadi.arstore.customer.model.CustomerResponse;

public class CustomerControllerMapper {

    public static CustomerDto toDto(CustomerRequest request) {
        return request != null ?
                CustomerDto.builder()
                        .id(request.getId())
                        .name(request.getName())
                        .gender(request.getGender())
                        .phoneNumber(request.getPhoneNumber())
                        .build() : null;
    }

    public static CustomerResponse toResponse(CustomerDto dto) {
        return dto != null ?
                CustomerResponse.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .gender(dto.getGender())
                        .phoneNumber(dto.getPhoneNumber())
                        .addresses(dto.getAddresses()
                                .stream()
                                .map(AddressControllerMapper::toResponse)
                                .toList()
                        )
                        .build() : null;
    }
}

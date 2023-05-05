package com.abbadi.arstore.customer;

import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.customer.model.CustomerRequest;
import com.abbadi.arstore.customer.model.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerControllerMapper implements GenericControllerMapper<Long, CustomerDto, CustomerRequest, CustomerResponse> {
    @Override
    public CustomerDto toDto(CustomerRequest request) {
        return CustomerDto.builder()
                .id(request.getId())
                .name(request.getName())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    @Override
    public CustomerResponse toResponse(CustomerDto dto) {
        return CustomerResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}

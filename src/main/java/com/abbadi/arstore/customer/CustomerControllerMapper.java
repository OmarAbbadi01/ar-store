package com.abbadi.arstore.customer;

import com.abbadi.arstore.address.AddressControllerMapper;
import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.customer.model.CustomerRequest;
import com.abbadi.arstore.customer.model.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerControllerMapper extends GenericControllerMapper<Long, CustomerDto, CustomerRequest, CustomerResponse> {

    private final AddressControllerMapper addressControllerMapper;

    @Override
    public CustomerDto mapToDto(CustomerRequest request) {
        return CustomerDto.builder()
                .id(request.getId())
                .name(request.getName())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    @Override
    public CustomerResponse mapToResponse(CustomerDto dto) {
        return CustomerResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .addresses(dto.getAddresses()
                        .stream()
                        .map(addressControllerMapper::toResponse)
                        .toList()
                )
                .build();
    }
}

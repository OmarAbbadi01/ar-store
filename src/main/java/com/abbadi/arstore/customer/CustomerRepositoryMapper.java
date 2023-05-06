package com.abbadi.arstore.customer;

import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.customer.model.Customer;
import com.abbadi.arstore.customer.model.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryMapper extends GenericRepositoryMapper<Long, Customer, CustomerDto> {

    @Override
    public CustomerDto mapToDto(Customer entity) {
        return CustomerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .gender(entity.getGender())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }

    @Override
    public Customer mapToEntity(CustomerDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}

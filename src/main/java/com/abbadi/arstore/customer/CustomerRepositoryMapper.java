package com.abbadi.arstore.customer;

import com.abbadi.arstore.address.AddressRepositoryMapper;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.customer.model.Customer;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.user.UserRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryMapper extends GenericRepositoryMapper<Long, Customer, CustomerDto> {

    private final AddressRepositoryMapper addressRepositoryMapper;

    private final UserRepositoryMapper userRepositoryMapper;

    @Override
    public CustomerDto mapToDto(Customer entity) {
        return CustomerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .gender(entity.getGender())
                .phoneNumber(entity.getPhoneNumber())
                .addresses(entity.getAddresses() != null ? entity.getAddresses()
                        .stream()
                        .map(addressRepositoryMapper::toDto)
                        .toList() : null)
                .userDto(userRepositoryMapper.toDto(entity.getUser()))
                .build();
    }

    @Override
    public Customer mapToEntity(CustomerDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .addresses(dto.getAddresses() != null ? dto.getAddresses()
                        .stream()
                        .map(addressRepositoryMapper::toEntity)
                        .toList() : null)
                .user(userRepositoryMapper.toEntity(dto.getUserDto()))
                .build();
    }
}

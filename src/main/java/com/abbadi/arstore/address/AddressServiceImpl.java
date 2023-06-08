package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.customer.CustomerRepository;
import com.abbadi.arstore.customer.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Long, AddressDto> implements AddressService {

    private final AddressRepository repository;

    private final CustomerRepository customerRepository;

    public AddressServiceImpl(AddressRepository repository, CustomerRepository customerRepository) {
        super(repository);
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    @Override
    public AddressDto findByCustomerIdAndAddressId(Long customerId, Long addressId) {
        validateCustomer(customerId);
        return Optional.ofNullable(repository.findByCustomerIdAndAddressId(customerId, addressId))
                .orElseThrow(() -> ArStoreException.builder()
                        .message("address not found")
                        .params(Collections.singletonList(addressId))
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @Override
    public List<AddressDto> findAllByCustomerId(Long customerId) {
        validateCustomer(customerId);
        return repository.findAllByCustomerId(customerId);
    }

    @Override
    public AddressDto create(AddressDto dto) {
        Long customerId = dto.getCustomerDto().getId();
        validateCustomer(customerId);
        CustomerDto customerDto = customerRepository.findById(customerId);
        dto.setCustomerDto(customerDto);
        dto = repository.create(dto);
        return dto;
    }

    private void validateCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw ArStoreException.builder()
                    .message("customer not found")
                    .params(Collections.singletonList(customerId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}

package com.abbadi.arstore.customer;

import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.customer.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Long, CustomerDto> implements CustomerService {

    private final CustomerRepository repository;

    private final CustomerRepositoryMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerRepositoryMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }
}

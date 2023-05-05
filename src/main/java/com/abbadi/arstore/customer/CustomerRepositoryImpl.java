package com.abbadi.arstore.customer;

import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import com.abbadi.arstore.customer.model.Customer;
import com.abbadi.arstore.customer.model.CustomerDto;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl extends GenericRepositoryImpl<Long, Customer, CustomerDto> implements CustomerRepository {

    private final CustomerDao dao;

    private final CustomerRepositoryMapper mapper;

    public CustomerRepositoryImpl(CustomerDao dao, CustomerRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }
}

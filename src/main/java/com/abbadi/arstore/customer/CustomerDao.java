package com.abbadi.arstore.customer;

import com.abbadi.arstore.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}

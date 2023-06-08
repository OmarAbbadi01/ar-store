package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDao extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Customer c JOIN c.addresses a WHERE c.id = :customerId AND a.id = :addressId")
    Address findByCustomerIdAndAddressId(Long customerId, Long addressId);

    @Query("SELECT a FROM Customer c JOIN c.addresses a WHERE c.id = :customerId")
    List<Address> findAllByCustomerId(Long customerId);
}

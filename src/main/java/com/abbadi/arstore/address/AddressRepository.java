package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

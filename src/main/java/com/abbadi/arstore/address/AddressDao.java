package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {
}

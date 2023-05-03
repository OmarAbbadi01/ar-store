package com.abbadi.arstore.store;

import com.abbadi.arstore.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDao extends JpaRepository<Store, Long> {
}

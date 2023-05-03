package com.abbadi.arstore.item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {
}

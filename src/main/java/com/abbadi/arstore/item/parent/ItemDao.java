package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.item.parent.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {
}

package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.item.parent.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ItemDao extends JpaRepository<Item, Long> {

    @Modifying
    @Query("DELETE Item i WHERE i.store.id = :storeId")
    void deleteAllByStoreId(Long storeId);
}

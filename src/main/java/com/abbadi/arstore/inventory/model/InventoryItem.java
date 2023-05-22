package com.abbadi.arstore.inventory.model;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import com.abbadi.arstore.item.parent.model.Item;
import com.abbadi.arstore.store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventoryItem implements GenericEntity<InventoryItemId> {

    @EmbeddedId
    private InventoryItemId id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

}

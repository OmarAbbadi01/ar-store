package com.abbadi.arstore.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InventoryItemId implements Serializable {

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "store_id")
    private Long storeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryItemId that)) return false;
        return getItemId().equals(that.getItemId()) && getStoreId().equals(that.getStoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getStoreId());
    }
}

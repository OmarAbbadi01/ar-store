package com.abbadi.arstore.cartitem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CartItemId implements Serializable {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "item_id")
    private Long itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemId that = (CartItemId) o;
        return getCustomerId().equals(that.getCustomerId()) && getItemId().equals(that.getItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getItemId());
    }
}

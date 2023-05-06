package com.abbadi.arstore.cartitem.model;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import com.abbadi.arstore.customer.model.Customer;
import com.abbadi.arstore.item.parent.model.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements GenericEntity<CartItemId> {

    @EmbeddedId
    private CartItemId id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;

}

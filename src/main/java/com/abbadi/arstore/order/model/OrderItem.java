package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import com.abbadi.arstore.item.parent.model.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements GenericEntity<OrderItemId> {

    @EmbeddedId
    private OrderItemId id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price_per_piece")
    private Double pricePerPiece;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item item;
}

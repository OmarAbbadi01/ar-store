package com.abbadi.arstore.cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cart")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @SequenceGenerator(name = "cartSequence", sequenceName = "cart_sequence", allocationSize = 1)
    @GeneratedValue(generator = "cartSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private List<CartItem> cartItems;
}

//package com.abbadi.arstore.cart.model;
//
//import com.abbadi.arstore.cartitem.model.CartItem;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Table(name = "cart")
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class CartItem {
//
//    @Id
//    @SequenceGenerator(name = "cartSequence", sequenceName = "cart_sequence", allocationSize = 1)
//    @GeneratedValue(generator = "cartSequence", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//
//    @OneToMany(mappedBy = "cart")
//    private List<CartItem> cartItems;
//}

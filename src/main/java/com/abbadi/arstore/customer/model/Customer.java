package com.abbadi.arstore.customer.model;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.cart.model.Cart;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "customerSequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(generator = "customerSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true, nullable = false)
    private Account account;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private List<Address> addresses;

    @OneToOne
    @JoinColumn(name = "cart_id", unique = true, nullable = false)
    private Cart cart;
}

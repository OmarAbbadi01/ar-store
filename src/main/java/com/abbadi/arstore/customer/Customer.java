package com.abbadi.arstore.customer;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.address.model.Address;
import com.abbadi.arstore.common.Gender;
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
public class Customer {

    @Id
    @SequenceGenerator(name = "customerSequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(generator = "customerSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private Gender geneder;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<Address> addresses;
}

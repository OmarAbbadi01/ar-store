package com.abbadi.arstore.customer;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.common.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // TODO: add Address

    @Column(name = "gender")
    private Gender geneder;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}

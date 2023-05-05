package com.abbadi.arstore.store.model;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.common.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "store")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "storeSequence", sequenceName = "store_sequence", allocationSize = 1)
    @GeneratedValue(generator = "storeSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id", unique = true, nullable = false)
    private Account account;

//    @OneToMany
//    @JoinColumn(name = "store_id")
//    private List<Item> items;
}

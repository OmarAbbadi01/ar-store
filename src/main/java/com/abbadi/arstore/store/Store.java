package com.abbadi.arstore.store;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.item.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "store")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @SequenceGenerator(name = "storeSequence", sequenceName = "store_sequence", allocationSize = 1)
    @GeneratedValue(generator = "storeSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

//    @OneToMany
//    @JoinColumn(name = "store_id")
//    private List<Item> items;
}

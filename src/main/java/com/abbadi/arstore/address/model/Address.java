package com.abbadi.arstore.address.model;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import com.abbadi.arstore.customer.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "addressSequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(generator = "addressSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zip")
    private String zip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}

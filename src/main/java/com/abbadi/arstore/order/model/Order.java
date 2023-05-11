package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import com.abbadi.arstore.customer.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orderr")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "orderSequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(generator = "orderSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "discount")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> ordersItems;
}

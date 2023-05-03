package com.abbadi.arstore.item;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.common.generic.model.GenericEntity;
import com.abbadi.arstore.store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "itemSequence", sequenceName = "item_sequence", allocationSize = 1)
    @GeneratedValue(generator = "itemSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}

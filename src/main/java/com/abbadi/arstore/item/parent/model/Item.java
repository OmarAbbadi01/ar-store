package com.abbadi.arstore.item.parent.model;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.cartitem.model.CartItem;
import com.abbadi.arstore.common.generic.model.GenericEntity;
import com.abbadi.arstore.item.photo.model.Photo;
import com.abbadi.arstore.store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    protected Long id;

    @Column(name = "description")
    protected String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "rating")
    protected Double rating;

    @Column(name = "number_of_votes")
    protected Integer numberOfVotes;

    @ManyToOne
    @JoinColumn(name = "store_id")
    protected Store store;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    protected Brand brand;

    @OneToMany(mappedBy = "item")
    protected List<CartItem> cartItems;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    protected List<Photo> photos;
}

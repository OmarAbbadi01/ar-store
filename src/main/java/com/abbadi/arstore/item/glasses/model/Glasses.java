package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.cartitem.model.CartItem;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.item.parent.model.Item;
import com.abbadi.arstore.store.model.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "glasses")
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Glasses extends Item { // TODO: some types can be converted to enum or other object

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "type")
    private String type; // TODO: what does this mean?

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "border")
    private String border;

    @Column(name = "shape")
    private String shape;

    @Builder(builderMethodName = "glassesBuilder")
    public Glasses(Long id, String description, Store store, Brand brand, List<CartItem> cartItems, String model, String color, String type, Gender gender, Double price, String border, String shape) {
        super(id, description, price, store, brand, cartItems);
        this.model = model;
        this.color = color;
        this.type = type;
        this.gender = gender;
        this.border = border;
        this.shape = shape;
    }

}

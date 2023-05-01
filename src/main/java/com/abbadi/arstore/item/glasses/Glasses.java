package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.item.Item;
import com.abbadi.arstore.store.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "glass")
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
// TODO: some types can be converted to enum or other object
public class Glasses extends Item {

    @Builder(builderMethodName = "glassesBuilder")
    public Glasses(Long id, String description, Store store, String brand, String model, String color, String type, Gender gender, Double price, String border, String shape) {
        super(id, description, store);
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.type = type;
        this.gender = gender;
        this.price = price;
        this.border = border;
        this.shape = shape;
    }

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "type")
    private String type;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "price")
    private Double price;

    @Column(name = "border")
    private String border;

    @Column(name = "shape")
    private String shape;

}

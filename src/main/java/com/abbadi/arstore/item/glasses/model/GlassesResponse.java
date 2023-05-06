package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.brand.model.BrandResponse;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericResponse;
import com.abbadi.arstore.item.parent.model.ItemResponse;
import com.abbadi.arstore.store.model.StoreResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GlassesResponse extends ItemResponse implements GenericResponse<Long> {

    private final String model;

    private final String color;

    private final String type;

    private final Gender gender;

    private final Double price;

    private final String border;

    private final String shape;

    @Builder(builderMethodName = "glassesResponseBuilder")
    public GlassesResponse(Long id, String description, StoreResponse storeResponse, BrandResponse brandResponse,
                           String model, String color, String type, Gender gender, Double price, String border, String shape) {
        super(id, description, storeResponse, brandResponse);
        this.model = model;
        this.color = color;
        this.type = type;
        this.gender = gender;
        this.price = price;
        this.border = border;
        this.shape = shape;
    }
}

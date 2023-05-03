package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericResponse;
import com.abbadi.arstore.store.Store;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class GlassesResponse implements GenericResponse<Long> {

    Long id;

    String description;

    Store store; //TODO: convert to StoreResponse

    Brand brand; // TODO: convert to BrandResponse

    String model;

    String color;

    String type;

    Gender gender;

    Double price;

    String border;

    String shape;
}

package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.store.Store;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GlassesDto implements GenericDto<Long> {

    private Long id;

    private String description;

    private Store store;

    private Long storeId;

    private Brand brand;

    private Long brandId;

    private String model;

    private String color;

    private String type;

    private Gender gender;

    private Double price;

    private String border;

    private String shape;

}

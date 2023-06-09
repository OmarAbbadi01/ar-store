package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.item.photo.model.PhotoDto;
import com.abbadi.arstore.store.model.StoreDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GlassesDto extends ItemDto implements GenericDto<Long> {

    private Long storeId;

    private Long brandId;

    private String model;

    private String color;

    private String type;

    private Gender gender;

    private String border;

    private String shape;

    private List<PhotoDto> photosDtos;

    @Builder(builderMethodName = "glassesDtoBuilder")
    public GlassesDto(Long id, String description, StoreDto storeDto, Long storeId, BrandDto brandDto, Long brandId,
                      String model, String color, String type, Gender gender, Double price, String border, String shape,
                      Double rating, Integer numberOfVotes, Integer quantity, List<PhotoDto> photosDtos) {
        super(id, description, price, rating, quantity, numberOfVotes, storeDto, brandDto);
        this.id = id;
        this.description = description;
        this.storeDto = storeDto;
        this.storeId = storeId;
        this.brandDto = brandDto;
        this.brandId = brandId;
        this.model = model;
        this.color = color;
        this.type = type;
        this.gender = gender;
        this.price = price;
        this.border = border;
        this.shape = shape;
        this.photosDtos = photosDtos;
    }
}

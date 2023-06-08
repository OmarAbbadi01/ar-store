package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.brand.model.BrandRequest;
import com.abbadi.arstore.brand.model.BrandResponse;

public class BrandControllerMapper {

    public static BrandDto toDto(BrandRequest request) {
        return request != null ?
                BrandDto.builder()
                        .id(request.getId())
                        .countryOfOrigin(request.getCountryOfOrigin())
                        .name(request.getName())
                        .build() : null;
    }

    public static BrandResponse toResponse(BrandDto dto) {
        return dto != null ?
                BrandResponse.builder()
                        .id(dto.getId())
                        .countryOfOrigin(dto.getCountryOfOrigin())
                        .name(dto.getName())
                        .build() : null;
    }
}

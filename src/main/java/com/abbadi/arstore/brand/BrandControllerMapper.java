package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.brand.model.BrandRequest;
import com.abbadi.arstore.brand.model.BrandResponse;
import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import org.springframework.stereotype.Component;

@Component
public class BrandControllerMapper implements GenericControllerMapper<Long, BrandDto, BrandRequest, BrandResponse> {

    @Override
    public BrandDto toDto(BrandRequest request) {
        return BrandDto.builder()
                .id(request.getId())
                .countryOfOrigin(request.getCountryOfOrigin())
                .name(request.getName())
                .build();
    }

    @Override
    public BrandResponse toResponse(BrandDto dto) {
        return BrandResponse.builder()
                .id(dto.getId())
                .countryOfOrigin(dto.getCountryOfOrigin())
                .name(dto.getName())
                .build();
    }
}
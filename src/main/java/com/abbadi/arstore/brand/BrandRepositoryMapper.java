package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import org.springframework.stereotype.Component;

@Component
public class BrandRepositoryMapper implements GenericRepositoryMapper<Long, Brand, BrandDto> {

    @Override
    public BrandDto toDto(Brand entity) {
        return BrandDto.builder()
                .id(entity.getId())
                .countryOfOrigin(entity.getCountryOfOrigin())
                .name(entity.getName())
                .build();
    }

    @Override
    public Brand toEntity(BrandDto dto) {
        return Brand.builder()
                .id(dto.getId())
                .countryOfOrigin(dto.getCountryOfOrigin())
                .name(dto.getName())
                .build();
    }
}

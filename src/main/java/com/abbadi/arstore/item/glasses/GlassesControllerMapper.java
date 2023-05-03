package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.glasses.model.GlassesResponse;
import org.springframework.stereotype.Component;

@Component
public class GlassesControllerMapper implements GenericControllerMapper<Long, GlassesDto, GlassesRequest, GlassesResponse> {

    @Override
    public GlassesDto toDto(GlassesRequest request) {
        return GlassesDto.builder()
                .id(request.getId())
                .description(request.getDescription())
                .storeId(request.getStoreId())
                .brandId(request.getBrandId())
                .model(request.getModel())
                .color(request.getColor())
                .type(request.getType())
                .gender(request.getGender())
                .price(request.getPrice())
                .border(request.getBorder())
                .shape(request.getShape())
                .build();
    }

    @Override
    public GlassesResponse toResponse(GlassesDto dto) {
        return GlassesResponse.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .store(dto.getStore())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .color(dto.getColor())
                .type(dto.getType())
                .gender(dto.getGender())
                .price(dto.getPrice())
                .border(dto.getBorder())
                .shape(dto.getShape())
                .build();
    }
}

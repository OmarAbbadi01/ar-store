package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.brand.BrandControllerMapper;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.glasses.model.GlassesResponse;
import com.abbadi.arstore.store.StoreControllerMapper;
import org.springframework.security.core.context.SecurityContextHolder;

public class GlassesControllerMapper {

    public static GlassesDto toDto(GlassesRequest request) {
        return request != null ?
                GlassesDto.glassesDtoBuilder()
                        .id(request.getId())
                        .description(request.getDescription())
                        .storeId((Long) SecurityContextHolder.getContext().getAuthentication().getDetails())
                        .brandId(request.getBrandId())
                        .model(request.getModel())
                        .color(request.getColor())
                        .type(request.getType())
                        .gender(request.getGender())
                        .price(request.getPrice())
                        .border(request.getBorder())
                        .shape(request.getShape())
                        .build() : null;
    }

    public static GlassesResponse toResponse(GlassesDto dto) {
        return dto != null ?
                GlassesResponse.glassesResponseBuilder()
                        .id(dto.getId())
                        .description(dto.getDescription())
                        .storeResponse(StoreControllerMapper.toResponse(dto.getStoreDto()))
                        .brandResponse(BrandControllerMapper.toResponse(dto.getBrandDto()))
                        .model(dto.getModel())
                        .color(dto.getColor())
                        .type(dto.getType())
                        .gender(dto.getGender())
                        .price(dto.getPrice())
                        .rating(dto.getRating())
                        .border(dto.getBorder())
                        .shape(dto.getShape())
                        .quantity(dto.getQuantity())
                        .build() : null;
    }

}

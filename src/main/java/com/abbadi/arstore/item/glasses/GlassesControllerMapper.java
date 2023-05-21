package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.brand.BrandControllerMapper;
import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.glasses.model.GlassesResponse;
import com.abbadi.arstore.store.StoreController;
import com.abbadi.arstore.store.StoreControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlassesControllerMapper extends GenericControllerMapper<Long, GlassesDto, GlassesRequest, GlassesResponse> {

    private final StoreControllerMapper storeControllerMapper;

    private final BrandControllerMapper brandControllerMapper;

    @Override
    public GlassesDto mapToDto(GlassesRequest request) {
        return GlassesDto.glassesDtoBuilder()
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
                .build();
    }

    @Override
    public GlassesResponse mapToResponse(GlassesDto dto) {
        return GlassesResponse.glassesResponseBuilder()
                .id(dto.getId())
                .description(dto.getDescription())
                .storeResponse(storeControllerMapper.toResponse(dto.getStoreDto()))
                .brandResponse(brandControllerMapper.toResponse(dto.getBrandDto()))
                .model(dto.getModel())
                .color(dto.getColor())
                .type(dto.getType())
                .gender(dto.getGender())
                .price(dto.getPrice())
                .rating(dto.getRating())
                .border(dto.getBorder())
                .shape(dto.getShape())
                .build();
    }
}

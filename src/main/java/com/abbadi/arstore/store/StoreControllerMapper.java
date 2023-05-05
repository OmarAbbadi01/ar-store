package com.abbadi.arstore.store;

import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.store.model.StoreDto;
import com.abbadi.arstore.store.model.StoreRequest;
import com.abbadi.arstore.store.model.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreControllerMapper implements GenericControllerMapper<Long, StoreDto, StoreRequest, StoreResponse> {

    @Override
    public StoreDto toDto(StoreRequest request) {
        return StoreDto.builder()
                .id(request.getId())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    @Override
    public StoreResponse toResponse(StoreDto dto) {
        return StoreResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}

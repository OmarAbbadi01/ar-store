package com.abbadi.arstore.store;

import com.abbadi.arstore.store.model.StoreDto;
import com.abbadi.arstore.store.model.StoreRequest;
import com.abbadi.arstore.store.model.StoreResponse;

public class StoreControllerMapper {

    public static StoreDto toDto(StoreRequest request) {
        return request != null ?
                StoreDto.builder()
                        .id(request.getId())
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .build() : null;
    }

    public static StoreResponse toResponse(StoreDto dto) {
        return dto != null ?
                StoreResponse.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .phoneNumber(dto.getPhoneNumber())
                        .build() : null;
    }
}

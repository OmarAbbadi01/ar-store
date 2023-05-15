package com.abbadi.arstore.store;

import com.abbadi.arstore.user.UserRepositoryMapper;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.store.model.Store;
import com.abbadi.arstore.store.model.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreRepositoryMapper extends GenericRepositoryMapper<Long, Store, StoreDto> {

    private final UserRepositoryMapper userRepositoryMapper;

    @Override
    public StoreDto mapToDto(Store entity) {
        return StoreDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .userDto(userRepositoryMapper.toDto(entity.getUser()))
                .build();
    }

    @Override
    public Store mapToEntity(StoreDto dto) {
        return Store.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .user(userRepositoryMapper.toEntity(dto.getUserDto()))
                .build();
    }
}


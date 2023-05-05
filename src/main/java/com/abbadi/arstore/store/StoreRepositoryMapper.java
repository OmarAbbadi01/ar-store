package com.abbadi.arstore.store;

import com.abbadi.arstore.account.AccountRepositoryMapper;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.store.model.Store;
import com.abbadi.arstore.store.model.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreRepositoryMapper implements GenericRepositoryMapper<Long, Store, StoreDto> {

    private final AccountRepositoryMapper accountRepositoryMapper;

    @Override
    public StoreDto toDto(Store entity) {
        return StoreDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .accountDto(accountRepositoryMapper.toDto(entity.getAccount()))
                .build();
    }

    @Override
    public Store toEntity(StoreDto dto) {
        return Store.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .account(dto.getAccountDto() != null ? accountRepositoryMapper.toEntity(dto.getAccountDto()) : null)
                .build();
    }
}

package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.brand.BrandRepository;
import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.item.glasses.model.Glasses;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.store.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlassesServiceImpl extends GenericServiceImpl<Long, GlassesDto, Glasses> implements GlassesService {

    private final GlassesRepository repository;

    private final BrandRepository brandRepository;

    private final StoreRepository storeRepository;

    private final GlassesRepositoryMapper mapper;

    public GlassesServiceImpl(GlassesRepository repository, BrandRepository brandRepository,
                              StoreRepository storeRepository, GlassesRepositoryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.brandRepository = brandRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    protected GlassesDto beforeCreate(GlassesDto dto) {
        checkBrandExistence(dto.getBrandId());
        checkStoreExistence(dto.getStoreId());
        dto.setBrand(brandRepository.findById(dto.getBrandId()).orElse(null));
        dto.setStore(storeRepository.findById(dto.getStoreId()).orElse(null));
        return dto;
    }

    @Override
    protected GlassesDto beforeUpdate(GlassesDto dto) {
        checkBrandExistence(dto.getBrandId());
        checkStoreExistence(dto.getStoreId());
        dto.setBrand(brandRepository.findById(dto.getBrandId()).orElse(null));
        dto.setStore(storeRepository.findById(dto.getStoreId()).orElse(null));
        return dto;
    }

    private void checkBrandExistence(Long brandId) {
        if (!brandRepository.existsById(brandId)) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.X_WITH_ID_NOT_FOUND)
                    .params(List.of("brand", brandId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    private void checkStoreExistence(Long brandId) {
        if (!storeRepository.existsById(brandId)) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.X_WITH_ID_NOT_FOUND)
                    .params(List.of("store", brandId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}

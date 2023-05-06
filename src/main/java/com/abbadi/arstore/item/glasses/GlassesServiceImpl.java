package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.brand.BrandRepository;
import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.store.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlassesServiceImpl extends GenericServiceImpl<Long, GlassesDto> implements GlassesService {

    private final GlassesRepository repository;

    private final StoreRepository storeRepository;

    private final BrandRepository brandRepository;

    public GlassesServiceImpl(GlassesRepository repository, StoreRepository storeRepository, BrandRepository brandRepository) {
        super(repository);
        this.repository = repository;
        this.storeRepository = storeRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    protected GlassesDto beforeCreate(GlassesDto dto) {
        return addMissingValues(dto);
    }

    @Override
    protected GlassesDto beforeUpdate(GlassesDto dto) {
        return addMissingValues(dto);
    }

    private GlassesDto addMissingValues(GlassesDto dto) {
        checkBrandExistence(dto.getBrandId());
        checkStoreExistence(dto.getStoreId());
        dto.setBrandDto(brandRepository.findById(dto.getBrandId()));
        dto.setStoreDto(storeRepository.findById(dto.getStoreId()));
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

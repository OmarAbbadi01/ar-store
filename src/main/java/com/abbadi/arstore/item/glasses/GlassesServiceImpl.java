package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import org.springframework.stereotype.Service;

@Service
public class GlassesServiceImpl extends GenericServiceImpl<Long, GlassesDto> implements GlassesService {

    private final GlassesRepository repository;

    public GlassesServiceImpl(GlassesRepository repository) {
        super(repository);
        this.repository = repository;
    }

//    @Override
//    protected GlassesDto beforeCreate(GlassesDto dto) {
//        checkBrandExistence(dto.getBrandId());
//        checkStoreExistence(dto.getStoreId());
//        dto.setBrand(brandRepository.findById(dto.getBrandId()).orElse(null));
//        dto.setStore(storeRepository.findById(dto.getStoreId()).orElse(null));
//        return dto;
//    }
//
//    @Override
//    protected GlassesDto beforeUpdate(GlassesDto dto) {
//        checkBrandExistence(dto.getBrandId());
//        checkStoreExistence(dto.getStoreId());
//        dto.setBrand(brandRepository.findById(dto.getBrandId()).orElse(null));
//        dto.setStore(storeRepository.findById(dto.getStoreId()).orElse(null));
//        return dto;
//    }
//
//    private void checkBrandExistence(Long brandId) {
//        if (!brandRepository.existsById(brandId)) {
//            throw ArStoreException.builder()
//                    .message(ArStoreExceptionMessages.X_WITH_ID_NOT_FOUND)
//                    .params(List.of("brand", brandId))
//                    .status(HttpStatus.NOT_FOUND)
//                    .build();
//        }
//    }
//
//    private void checkStoreExistence(Long brandId) {
//        if (!storeRepository.existsById(brandId)) {
//            throw ArStoreException.builder()
//                    .message(ArStoreExceptionMessages.X_WITH_ID_NOT_FOUND)
//                    .params(List.of("store", brandId))
//                    .status(HttpStatus.NOT_FOUND)
//                    .build();
//        }
//    }
}

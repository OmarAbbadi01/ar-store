package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.brand.BrandRepository;
import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.inventory.InventoryRepository;
import com.abbadi.arstore.inventory.InventoryService;
import com.abbadi.arstore.inventory.model.InventoryItemId;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.store.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.ID_NOT_FOUND;

@Service
public class GlassesServiceImpl extends GenericServiceImpl<Long, GlassesDto> implements GlassesService {

    private final GlassesRepository repository;

    private final StoreRepository storeRepository;

    private final BrandRepository brandRepository;

    private final InventoryRepository inventoryRepository;

    public GlassesServiceImpl(GlassesRepository repository, StoreRepository storeRepository, BrandRepository brandRepository,
                              InventoryRepository inventoryRepository) {
        super(repository);
        this.repository = repository;
        this.storeRepository = storeRepository;
        this.brandRepository = brandRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public GlassesDto findById(Long id) {
        GlassesDto dto = Optional.ofNullable(repository.findById(id))
                .orElseThrow(() -> ArStoreException.builder()
                        .params(Collections.singletonList(id))
                        .message(ID_NOT_FOUND)
                        .status(HttpStatus.NOT_FOUND)
                        .build());
        Integer quantity = inventoryRepository.findById(InventoryItemId.builder()
                        .storeId(dto.getStoreId())
                        .itemId(dto.getId())
                        .build())
                .getQuantity();
        dto.setQuantity(quantity);
        return dto;
    }

    @Override
    public List<GlassesDto> findAll() {
        return repository.findAll()
                .stream()
                .peek(dto -> {
                    Integer quantity = inventoryRepository.findById(InventoryItemId.builder()
                                    .storeId(dto.getStoreId())
                                    .itemId(dto.getId())
                                    .build())
                            .getQuantity();
                    dto.setQuantity(quantity);
                })
                .toList();
    }

    @Override
    protected GlassesDto beforeCreate(GlassesDto dto) {
        dto.setRating(0D);
        dto.setNumberOfVotes(0);
        return addMissingValues(dto);
    }

    @Override
    protected GlassesDto beforeUpdate(GlassesDto dto) {
        return addMissingValues(dto);
    }

    @Override
    public void rate(Long itemId, Integer value) {
        checkItemExists(itemId);
        GlassesDto dto = repository.findById(itemId);
        Double newRating = (value + dto.getRating()) / (dto.getNumberOfVotes() + 1);
        dto.setRating(newRating);
        dto.setNumberOfVotes(dto.getNumberOfVotes() + 1);
        repository.update(dto);
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

    private void checkItemExists(Long itemId) {
        if (!repository.existsById(itemId)) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.ID_NOT_FOUND)
                    .params(List.of(itemId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}

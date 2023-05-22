package com.abbadi.arstore.inventory;

import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemId;
import com.abbadi.arstore.item.parent.ItemRepository;
import com.abbadi.arstore.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final StoreRepository storeRepository;

    private final ItemRepository itemRepository;


    @Override
    public List<InventoryItemDto> findAll(Long storeId) {
        validateStore(storeId);
        return inventoryRepository.findAllItemsInInventory(storeId);
    }

    @Override
    public void delete(InventoryItemId id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public void update(InventoryItemDto dto) {
        validateStore(dto.getId().getStoreId());
        validateItem(dto.getId().getItemId(), dto.getId().getStoreId());
        dto.setItemDto(itemRepository.findById(dto.getId().getItemId()));
        dto.setStoreDto(storeRepository.findById(dto.getId().getStoreId()));
        inventoryRepository.update(dto);
    }

    @Override
    public InventoryItemId create(InventoryItemDto dto) {
        validateStore(dto.getId().getStoreId());
        validateItem(dto.getId().getItemId(), dto.getId().getStoreId());
        dto.setItemDto(itemRepository.findById(dto.getId().getItemId()));
        dto.setStoreDto(storeRepository.findById(dto.getId().getStoreId()));
        dto = inventoryRepository.create(dto);
        return dto.getId();
    }

    private void validateStore(Long storeId) {
        if (!storeRepository.existsById(storeId)) {
            throw ArStoreException.builder()
                    .message("Store does not exists")
                    .params(Collections.singletonList(storeId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    private void validateItem(Long itemId, Long storeId) {
        if (!itemRepository.existsById(itemId)) {
            throw ArStoreException.builder()
                    .message("Item does not exists")
                    .params(Collections.singletonList(itemId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        if (!itemRepository.findById(itemId).getStoreDto().getId().equals(storeId)) {
            throw ArStoreException.builder()
                    .message("Item does not belong to this store")
                    .params(List.of(itemId, storeId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}

package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.common.generic.service.GenericRepository;
import com.abbadi.arstore.item.parent.model.ItemDto;

public interface ItemRepository extends GenericRepository<Long, ItemDto> {

    void deleteAllByStoreId(Long storeId);
}

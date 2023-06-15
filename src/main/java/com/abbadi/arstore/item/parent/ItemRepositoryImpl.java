package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import com.abbadi.arstore.item.parent.model.Item;
import com.abbadi.arstore.item.parent.model.ItemDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ItemRepositoryImpl extends GenericRepositoryImpl<Long, Item, ItemDto> implements ItemRepository {

    private final ItemDao dao;

    private final ItemRepositoryMapper mapper;

    public ItemRepositoryImpl(ItemDao dao, ItemRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void deleteAllByStoreId(Long storeId) {
        dao.deleteAllByStoreId(storeId);
    }
}

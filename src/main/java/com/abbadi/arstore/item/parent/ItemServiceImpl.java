package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.item.parent.model.ItemDto;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Long, ItemDto> implements ItemService {

    private final ItemRepository repository;


    public ItemServiceImpl(ItemRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public ItemDto beforeUpdate(ItemDto itemDto) {
        Double rating = repository.findById(itemDto.getId()).getRating();
        Integer numberOfVotes = repository.findById(itemDto.getId()).getNumberOfVotes();
        itemDto.setRating(rating);
        itemDto.setNumberOfVotes(numberOfVotes);
        return itemDto;
    }
}

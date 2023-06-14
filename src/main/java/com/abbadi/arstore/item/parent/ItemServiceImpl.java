package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.item.photo.PhotoUploadService;
import io.jsonwebtoken.io.IOException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Long, ItemDto> implements ItemService {

    private final ItemRepository repository;

    private final PhotoUploadService photoUploadService;

    public ItemServiceImpl(ItemRepository repository, PhotoUploadService photoUploadService) {
        super(repository);
        this.repository = repository;
        this.photoUploadService = photoUploadService;
    }

    @Override
    public ItemDto beforeUpdate(ItemDto itemDto) {
        Double rating = repository.findById(itemDto.getId()).getRating();
        Integer numberOfVotes = repository.findById(itemDto.getId()).getNumberOfVotes();
        itemDto.setRating(rating);
        itemDto.setNumberOfVotes(numberOfVotes);
        return itemDto;
    }

//    @Override
//    public ItemDto create(ItemDto dto) throws IOException {
//        dto.getPhotos()
//                .forEach(photo -> {
//                    try {
//                        String url = photoUploadService.uploadPhoto(photo.getMultipartFile());
//                        photo.setUrl(url);
//                    } catch (java.io.IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//        return repository.create(dto);
//    }
}

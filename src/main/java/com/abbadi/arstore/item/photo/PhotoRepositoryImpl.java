package com.abbadi.arstore.item.photo;

import com.abbadi.arstore.item.photo.model.PhotoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PhotoRepositoryImpl implements PhotoRepository {

    private final PhotoDao dao;

    private final PhotoRepositoryMapper mapper;

    @Override
    public PhotoDto create(PhotoDto dto) {
        return mapper.toDto(dao.save(mapper.toEntity(dto)));
    }
}


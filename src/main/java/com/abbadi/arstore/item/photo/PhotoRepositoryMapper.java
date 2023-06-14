package com.abbadi.arstore.item.photo;

import com.abbadi.arstore.item.parent.ItemRepositoryMapper;
import com.abbadi.arstore.item.photo.model.Photo;
import com.abbadi.arstore.item.photo.model.PhotoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PhotoRepositoryMapper {

    public PhotoDto toDto(Photo photo) {
        return photo != null ?
                PhotoDto.builder()
                        .url(photo.getUrl())
                        .build()
                : null;
    }

    public Photo toEntity(PhotoDto dto) {
        return dto != null ?
                Photo.builder()
                        .url(dto.getUrl())
                        .build()
                : null;
    }
}

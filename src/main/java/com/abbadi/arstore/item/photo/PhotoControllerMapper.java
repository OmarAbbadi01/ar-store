package com.abbadi.arstore.item.photo;

import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.item.photo.model.PhotoDto;
import com.abbadi.arstore.item.photo.model.PhotosUploadRequest;

import java.util.List;

public class PhotoControllerMapper {

    private PhotoControllerMapper() {

    }

    public static List<PhotoDto> toDto(PhotosUploadRequest request, Long id) {
        return request != null ?
                request.getPhotos()
                        .stream()
                        .map(file -> PhotoDto.builder()
                                .multipartFile(file)
                                .itemDto(ItemDto.builder()
                                        .id(id)
                                        .build())
                                .build())
                        .toList()
                : null;
    }

    public static List<String> toUrlsResponse(List<PhotoDto> dtos) {
        return dtos != null ?
                dtos.stream()
                        .map(PhotoDto::getUrl)
                        .toList()
                : null;
    }
}

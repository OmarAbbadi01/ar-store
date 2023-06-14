package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericService;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.photo.model.PhotoDto;

import java.util.List;

public interface GlassesService extends GenericService<Long, GlassesDto> {

    void rate(Long itemId, Integer value);

    List<PhotoDto> uploadPhotos(List<PhotoDto> photosDtos);

}

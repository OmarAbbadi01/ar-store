package com.abbadi.arstore.item.photo.model;

import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.PHOTOS_NUMBER_MUST_BE_BETWEEN_ZERO_AND_FOUR;

@Value
public class PhotosUploadRequest {

    @Size(min = 0, max = 4, message = PHOTOS_NUMBER_MUST_BE_BETWEEN_ZERO_AND_FOUR)
    List<MultipartFile> photos;

}

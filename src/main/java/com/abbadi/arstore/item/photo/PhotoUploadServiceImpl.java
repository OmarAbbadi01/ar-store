package com.abbadi.arstore.item.photo;

import com.abbadi.arstore.item.photo.model.PhotoDto;
import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoUploadServiceImpl implements PhotoUploadService {

    private final Cloudinary cloudinary;

    @Override
    public String uploadPhoto(MultipartFile multipartFile) throws IOException {
        Map map = cloudinary.uploader()
                .upload(multipartFile.getBytes(), Map.of("public_id", UUID.randomUUID().toString()));
        PhotoDto photoDto = PhotoDto.builder()
                .url((String) map.get("url"))
                .build();
        return photoDto.getUrl();
    }
}

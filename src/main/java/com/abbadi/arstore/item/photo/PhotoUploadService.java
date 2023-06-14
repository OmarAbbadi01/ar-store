package com.abbadi.arstore.item.photo;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoUploadService {

    String uploadPhoto(MultipartFile multipartFile) throws IOException;

}

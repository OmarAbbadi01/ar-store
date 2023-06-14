package com.abbadi.arstore.item.photo.model;

import com.abbadi.arstore.item.parent.model.ItemDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Builder
@Data
public class PhotoDto {

    private MultipartFile multipartFile;

    private String url;

    private ItemDto itemDto;

}

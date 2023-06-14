package com.abbadi.arstore.item.photo;

import com.abbadi.arstore.item.photo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDao extends JpaRepository<Photo, String> {
}

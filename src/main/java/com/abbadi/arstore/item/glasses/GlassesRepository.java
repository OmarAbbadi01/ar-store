package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericRepository;
import com.abbadi.arstore.item.glasses.model.Glasses;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlassesRepository extends GenericRepository<Long, GlassesDto> {
}

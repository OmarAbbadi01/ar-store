package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}

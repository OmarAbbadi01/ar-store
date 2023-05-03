package com.abbadi.arstore.brand.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BrandDto implements GenericDto<Long> {

    private Long id;

    private String name;

    private String logoUrl;

    private String countryOfOrigin;

}

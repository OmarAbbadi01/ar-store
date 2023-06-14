package com.abbadi.arstore.item.parent.model;

import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.store.model.StoreDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto implements GenericDto<Long> {

    protected Long id;

    protected String description;

    protected Double price;

    protected Double rating;

    protected Integer quantity;

    protected Integer numberOfVotes;

    protected StoreDto storeDto;

    protected BrandDto brandDto;
}

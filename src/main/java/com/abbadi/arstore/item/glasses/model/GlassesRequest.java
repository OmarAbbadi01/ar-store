package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.item.parent.model.ItemRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;

@Getter
public class GlassesRequest extends ItemRequest implements GenericRequest<Long> {

    @NotNull(message = CAN_NOT_BE_NULL)
    private final Long brandId;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    private final String model;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    private final String color;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    private final String type;

    @NotNull(message = CAN_NOT_BE_NULL)
    private final Gender gender;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    private final String border;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    private final String shape;

    public GlassesRequest(Long id, String description, Long brandId, String model, String color, String type,
                          Gender gender, Double price, String border, String shape) {
        super(id, description, price);
        this.brandId = brandId;
        this.model = model;
        this.color = color;
        this.type = type;
        this.gender = gender;
        this.border = border;
        this.shape = shape;
    }
}

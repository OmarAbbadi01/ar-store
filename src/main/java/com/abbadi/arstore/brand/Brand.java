package com.abbadi.arstore.brand;

import com.abbadi.arstore.common.generic.model.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements GenericEntity<Long> {

    @Id
    @SequenceGenerator(name = "brandSequence", sequenceName = "brand_sequence", allocationSize = 1)
    @GeneratedValue(generator = "brandSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "logoUrl")
    private String logoUrl;

    @Column(name = "countryOfOrigin")
    private String countryOfOrigin;
}

package com.abbadi.arstore.item.photo.model;

import com.abbadi.arstore.item.parent.model.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "photo")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Photo {

    @Id
    @Column(name = "url")
    private String url;

}

package com.northcoders.record_shop.RecordShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    Long id;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn
    Artist artist;

    @Column
    String name;

    @Column
    String description;

    @Column
    String albumArtUrl;

    @Column
    Genre genre;

    @Column
    AlbumType type;

    @Column
    Long stockCount;

    @Column(scale = 2)
    BigDecimal cost;
}

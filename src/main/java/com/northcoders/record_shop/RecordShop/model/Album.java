package com.northcoders.record_shop.RecordShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    Long stockCount;

    @Column(scale = 2)
    BigDecimal cost;
}

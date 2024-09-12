package com.northcoders.record_shop.RecordShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {
    public Long getId() {
        return this.id;
    }

    public Set<Artist> getArtists() {
        return this.artists;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAlbumArtUrl() {
        return this.albumArtUrl;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public AlbumType getType() {
        return this.type;
    }

    public Long getStockCount() {
        return this.stockCount;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    Long id;

    @ManyToMany
    @JoinTable(
            name = "artists_albums",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_name"))
    Set<Artist> artists = new HashSet<>();

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

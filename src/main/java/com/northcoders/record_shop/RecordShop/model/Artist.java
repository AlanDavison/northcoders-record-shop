package com.northcoders.record_shop.RecordShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist {
    public String getName() {
        return this.name;
    }

    public String getPortraitImageUrl() {
        return this.portraitImageUrl;
    }

    public Set<Album> getAlbums() {
        return this.albums;
    }

    @Id
    @Column(nullable = false)
    String name;

    @Column
    String portraitImageUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "artists")
    @Cascade(CascadeType.ALL)
    @Column
    Set<Album> albums = new HashSet<>();
}

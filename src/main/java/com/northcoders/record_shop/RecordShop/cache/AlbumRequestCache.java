package com.northcoders.record_shop.RecordShop.cache;

import com.northcoders.record_shop.RecordShop.exception.AlbumNotFoundException;
import com.northcoders.record_shop.RecordShop.model.Album;
import com.northcoders.record_shop.RecordShop.repository.RecordShopRepository;
import lombok.Singular;
import org.h2.command.ddl.AlterUser;
import org.h2.util.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class AlbumRequestCache {
    Logger logger = LoggerFactory.getLogger(AlbumRequestCache.class);

    @Autowired
    private RecordShopRepository repo;

    private HashMap<Long, CachedAlbum> requestCache = new HashMap<>();

    public Optional<Album> getAlbumById(Long id) {
        if (this.requestCache.containsKey(id)) {
            this.logger.info(String.format("Found album with ID %d in cache. Skipping querying database.", id));
            CachedAlbum cachedAlbum = this.requestCache.get(id);

            if (cachedAlbum.isExpired()) {
                return this.repo.findById(id);
            }

            return Optional.of(cachedAlbum.getAlbum());
        }

        this.logger.info(String.format("Didn't find album with ID %d in cache. Checking the database.", id));

        Optional<Album> foundAlbum = this.repo.findById(id);

        if (foundAlbum.isPresent()) {
            CachedAlbum albumForCache = new CachedAlbum(foundAlbum.get());
            this.requestCache.put(id, albumForCache);

            return foundAlbum;
        }

        return Optional.empty();
    }

    public void invalidateCacheForAlbum(Album album) {
        Set<Long> albumIdsInCache = this.requestCache.keySet();

        for (Long id: albumIdsInCache) {
            if (this.requestCache.containsKey(id)) {
                if (this.requestCache.get(id).getAlbum().equals(album)) {
                    this.requestCache.remove(id);
                }
            }
        }
    }
}

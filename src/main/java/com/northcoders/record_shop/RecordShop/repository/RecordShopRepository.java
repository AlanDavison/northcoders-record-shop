package com.northcoders.record_shop.RecordShop.repository;

import com.northcoders.record_shop.RecordShop.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecordShopRepository extends CrudRepository<Album, Long> {
}

package com.example.twitchdemo.db;

import com.example.twitchdemo.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ItemRepository extends ListCrudRepository<ItemEntity, Long> {

    ItemEntity findByTwitchId(String twitchId);

}
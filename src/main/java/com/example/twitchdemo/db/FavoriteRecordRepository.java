package com.example.twitchdemo.db;
import com.example.twitchdemo.db.entity.FavoriteRecordEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
public interface FavoriteRecordRepository extends ListCrudRepository<FavoriteRecordEntity, Long> {
    List<FavoriteRecordEntity> findAllByUserId(Long userId);
    boolean existsByUserIdAndItemId(Long userId, Long itemId);
    @Query("SELECT item_id FROM favorite_records WHERE user_id = :userId")
    List<Long> findFavoriteItemIdsByUserId(Long userId);

    @Modifying
    @Query("DELETE FROM favorite_records WHERE user_id = :userId AND item_id = :itemId")
    void delete(Long userId, Long itemId);

}

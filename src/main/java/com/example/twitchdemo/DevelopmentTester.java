package com.example.twitchdemo;
import com.example.twitchdemo.db.FavoriteRecordRepository;
import com.example.twitchdemo.db.ItemRepository;
import com.example.twitchdemo.db.UserRepository;
import com.example.twitchdemo.db.entity.UserEntity;
import com.example.twitchdemo.db.entity.FavoriteRecordEntity;
import com.example.twitchdemo.db.entity.ItemEntity;
import com.example.twitchdemo.model.ItemType;
import com.example.twitchdemo.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class DevelopmentTester implements ApplicationRunner {


    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);


    private final UserService userService;


    public DevelopmentTester(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(ApplicationArguments args) {
        userService.register("default", "123456", "John", "Smith");
    }
}

/*
public class DevelopmentTester implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final FavoriteRecordRepository favoriteRecordRepository;

    public DevelopmentTester(UserRepository userRepository, ItemRepository itemRepository, FavoriteRecordRepository favoriteRecordRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.favoriteRecordRepository = favoriteRecordRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        UserEntity newUser = new UserEntity(null, "user0", "Foo", "Bar", "password");
        userRepository.save(newUser);

        UserEntity user1 = new UserEntity(null, "user1", "John", "Smith", "password");
        UserEntity user2 = new UserEntity(null, "user2", "Jane", "Smith", "password");
        UserEntity user3 = new UserEntity(null, "user3", "John", "Doe", "password");

        userRepository.saveAll(List.of(user1, user2, user3));

        ItemEntity newItem = new ItemEntity(null, "abc0", "Title0", "url0", "thumb0", "name0", "game0", ItemType.CLIP);
        itemRepository.save(newItem);

        List<ItemEntity> newItems = List.of(
                new ItemEntity(null, "abc1", "Title1", "url1", "thumb1", "name1", "game1", ItemType.VIDEO),
                new ItemEntity(null, "abc2", "Title2", "url2", "thumb2", "name2", "game2", ItemType.VIDEO),
                new ItemEntity(null, "abc3", "Title3", "url3", "thumb3", "name3", "game3", ItemType.STREAM),
                new ItemEntity(null, "abc4", "Title4", "url4", "thumb4", "name4", "game4", ItemType.STREAM)
        );
        itemRepository.saveAll(newItems);
        favoriteRecordRepository.saveAll(
                List.of(
                        new FavoriteRecordEntity(null, 1L, 1L, Instant.now()),
                        new FavoriteRecordEntity(null, 1L, 3L, Instant.now()),
                        new FavoriteRecordEntity(null, 1L, 4L, Instant.now()),
                        new FavoriteRecordEntity(null, 2L, 2L, Instant.now())
                )
        );

        userRepository.updateNameByUsername("user0", "Far", "Boo");
        List<UserEntity> johns = userRepository.findByFirstName("John");
        // logger.info("John: " + johns);
        List<UserEntity> smiths = userRepository.findByLastName("Smith");
        // logger.info("Smith: " + smiths);

        UserEntity user0 = userRepository.findByUsername("user0");
        // logger.info("user0: " + user0);

        boolean item1Exists = itemRepository.existsById(1L);
        boolean item100Exists = itemRepository.existsById(100L);
        // logger.info("Item1exists: " + item1Exists);
        // logger.info("Item100exists: " + item100Exists);

        itemRepository.deleteById(2L);

        boolean item2Exists = itemRepository.existsById(2L);
        ItemEntity abc1 = itemRepository.findByTwitchId("abc1");

        List<FavoriteRecordEntity> user1Favorites = favoriteRecordRepository.findAllByUserId(1L);
        List<FavoriteRecordEntity> user2Favorites = favoriteRecordRepository.findAllByUserId(2L);

        List<Long> user1FavoriteItemIds = favoriteRecordRepository.findFavoriteItemIdsByUserId(1L);
        List<Long> user2FavoriteItemIds = favoriteRecordRepository.findFavoriteItemIdsByUserId(2L);

        favoriteRecordRepository.delete(1L, 3L);
        List<FavoriteRecordEntity> user1FavoritesAfterDelete = favoriteRecordRepository.findAllByUserId(1L);
    }
}*/

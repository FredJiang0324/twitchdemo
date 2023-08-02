package com.example.twitchdemo.item;

import com.example.twitchdemo.external.TwitchService;
import com.example.twitchdemo.external.model.Clip;
import com.example.twitchdemo.external.model.Stream;
import com.example.twitchdemo.external.model.Video;
import com.example.twitchdemo.model.TypeGroupedItemList;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

@Service
public class ItemService {

    private static final int SEARCH_RESULT_SIZE = 20;

    private final TwitchService twitchService;

    public ItemService(TwitchService twitchService) {
        this.twitchService = twitchService;
    }

    @Cacheable("items")
    public TypeGroupedItemList getItems(String gameId) {
        List<Video> videos = twitchService.getVideos(gameId, SEARCH_RESULT_SIZE);
        List<Clip> clips = twitchService.getClips(gameId, SEARCH_RESULT_SIZE);
        List<Stream> streams = twitchService.getStreams(List.of(gameId), SEARCH_RESULT_SIZE);
        return new TypeGroupedItemList(gameId, streams, videos, clips);
    }
}

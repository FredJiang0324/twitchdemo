package com.example.twitchdemo.external;

import com.example.twitchdemo.external.model.Clip;
import com.example.twitchdemo.external.model.Game;
import com.example.twitchdemo.external.model.Stream;
import com.example.twitchdemo.external.model.Video;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class TwitchService {


    private final TwitchApiClient twitchApiClient;


    public TwitchService(TwitchApiClient twitchApiClient) {
        this.twitchApiClient = twitchApiClient;
    }


    public List<Game> getTopGames() {
        return twitchApiClient.getTopGames().data();
    }


    public List<Game> getGames(String name) {
        return twitchApiClient.getGames(name).data();
    }


    public List<Stream> getStreams(List<String> gameIds, int first) {
        return twitchApiClient.getStreams(gameIds, first).data();
    }


    public List<Video> getVideos(String gameId, int first) {
        return twitchApiClient.getVideos(gameId, first).data();
    }


    public List<Clip> getClips(String gameId, int first) {
        return twitchApiClient.getClips(gameId, first).data();
    }


    public List<String> getTopGameIds() throws IOException {
        List<String> topGameIds = new ArrayList<>();
        for (Game game : getTopGames()) {
            topGameIds.add(game.id());
        }
        return topGameIds;
    }
}

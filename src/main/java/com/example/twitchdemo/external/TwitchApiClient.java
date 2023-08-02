package com.example.twitchdemo.external;
import com.example.twitchdemo.external.model.ClipResponse;
import com.example.twitchdemo.external.model.GameResponse;
import com.example.twitchdemo.external.model.StreamResponse;
import com.example.twitchdemo.external.model.VideoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@FeignClient(name = "twitch-api")
public interface TwitchApiClient {
    @GetMapping("/games")
    GameResponse getGames(@RequestParam("name") String name);
    @GetMapping("/games/top")
    GameResponse getTopGames();
    @GetMapping("/videos/")
    VideoResponse getVideos(@RequestParam("game_id") String gameId, @RequestParam("first") int first);
    @GetMapping("/clips/")
    ClipResponse getClips(@RequestParam("game_id") String gameId, @RequestParam("first") int first);
    @GetMapping("/streams/")
    StreamResponse getStreams(@RequestParam("game_id") List<String> gameIds, @RequestParam("first") int first);


}

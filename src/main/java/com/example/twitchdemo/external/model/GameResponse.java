package com.example.twitchdemo.external;

import java.util.List;


public record GameResponse(
        List<Game> data
) {
}

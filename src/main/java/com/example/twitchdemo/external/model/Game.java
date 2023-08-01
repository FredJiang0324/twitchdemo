package com.example.twitchdemo.external;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Game(
        String id,
        String name,
        @JsonProperty("box_art_url") String boxArtUrl
) {
}

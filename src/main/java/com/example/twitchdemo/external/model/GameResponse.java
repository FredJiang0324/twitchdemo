package com.example.twitchdemo.external.model;

import com.example.twitchdemo.external.model.Game;

import java.util.List;


public record GameResponse(
        List<Game> data
) {
}

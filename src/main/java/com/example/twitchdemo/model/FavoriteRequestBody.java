package com.example.twitchdemo.model;

import com.example.twitchdemo.db.entity.ItemEntity;

public record FavoriteRequestBody(
        ItemEntity favorite
) {}
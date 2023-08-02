package com.example.twitchdemo.external.model;

import com.example.twitchdemo.external.model.Stream;

import java.util.List;


public record StreamResponse(
        List<Stream> data
) {
}

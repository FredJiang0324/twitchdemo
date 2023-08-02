package com.example.twitchdemo.external.model;

import com.example.twitchdemo.external.model.Clip;

import java.util.List;


public record ClipResponse(
        List<Clip> data
) {
}

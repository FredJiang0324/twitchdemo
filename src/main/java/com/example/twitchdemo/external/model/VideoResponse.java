package com.example.twitchdemo.external.model;



import com.example.twitchdemo.external.model.Video;

import java.util.List;


public record VideoResponse(
        List<Video> data
) {
}

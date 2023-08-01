package com.example.twitchdemo.external;



import java.util.List;


public record VideoResponse(
        List<Video> data
) {
}

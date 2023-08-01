package com.example.twitchdemo.external;

import java.util.List;


public record StreamResponse(
        List<Stream> data
) {
}

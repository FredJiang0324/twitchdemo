package com.example.twitchdemo.external;

import java.util.List;


public record ClipResponse(
        List<Clip> data
) {
}

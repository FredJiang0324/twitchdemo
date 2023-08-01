package com.example.twitchdemo;

public record TwitchErrorResponse(
        String message,
        String error,
        String details
) {
}
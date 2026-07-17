package com.example.dto;

public record ContactResponse(
        long userId,
        String mob,
        String emailId
) {
}

package com.example.dto;

public record ContactRequest(
        String mobileNumber,
        String email
) {
}
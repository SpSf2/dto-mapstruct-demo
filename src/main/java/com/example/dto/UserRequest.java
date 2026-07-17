package com.example.dto;

import java.time.LocalDate;
import java.util.Set;

public record UserRequest(
        String username,
        String password,
        LocalDate dateOfBirth,
        String status,
        Set<ContactRequest> contacts
) {
}
package com.example.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

// La siguiente anotacion es para que el proceso de deserializacion solo muestre
// propiedades que no sean NULL
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponse(
        long id,
        String name,
        String dob,
        String status,
        Set<ContactResponse> contacts
) {
}
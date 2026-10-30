package com.ecom.users.dto.response;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record AddressResponse (
        UUID id,
        String recipientName,
        String line1,
        String line2,
        String city,
        String stateOrProvince,
        String postalCode,
        String country,
        LocalDateTime createdAt,
        LocalDateTime updatedAt){

}

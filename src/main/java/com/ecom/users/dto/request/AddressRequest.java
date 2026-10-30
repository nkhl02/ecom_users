package com.ecom.users.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest (
        @NotBlank String recipientName,
        @NotBlank String line1,
        String line2,
        @NotBlank String city,
        @NotBlank String stateOrProvince,
        @NotBlank String postalCode,
        @NotBlank String country
){ }

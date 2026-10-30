package com.ecom.users.dto.response;

import com.ecom.users.entity.Address;
import com.ecom.users.enums.Role;
import com.ecom.users.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse (
        UUID id,
        String email,
        String firstName,
        String lastName,
        String phoneNumber,
        Role role,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        AddressResponse address
){ }

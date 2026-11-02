package com.ecom.users.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest (
        String firstName,
        String lastName,
        @Size(max=10) String phoneNumber
){
}

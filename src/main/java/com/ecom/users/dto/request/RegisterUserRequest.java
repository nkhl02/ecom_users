package com.ecom.users.dto.request;

import com.ecom.users.enums.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest (@Email @NotBlank String email,
                                   @NotBlank String firstName,
                                   String lastName,
                                   @NotBlank String password,
                                   @Size(max=10) String phoneNumber,
                                   @Valid @NotNull AddressRequest address){ }
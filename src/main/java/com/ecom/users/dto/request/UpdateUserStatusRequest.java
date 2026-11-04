package com.ecom.users.dto.request;


import com.ecom.users.enums.Status;
import jakarta.validation.constraints.NotNull;

public record UpdateUserStatusRequest (@NotNull Status status){
}


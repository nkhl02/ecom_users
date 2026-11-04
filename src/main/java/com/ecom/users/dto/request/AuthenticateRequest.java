package com.ecom.users.dto.request;

import lombok.NonNull;

public record AuthenticateRequest (@NonNull String username,
                                   @NonNull String password){
}

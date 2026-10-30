package com.ecom.users.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse (
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
){
}

package com.ecom.users.dto.response;

import com.ecom.users.enums.Role;

import java.util.List;
import java.util.UUID;

public record AuthenicatedUserResponse (UUID userId,
                                        String username,
                                        Role role){

}

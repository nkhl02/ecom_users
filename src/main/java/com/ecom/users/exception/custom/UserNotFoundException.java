package com.ecom.users.exception.custom;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{

   public UserNotFoundException(UUID userId){
        super("An account with userId '" + userId + "' does not exists.");
   }
}

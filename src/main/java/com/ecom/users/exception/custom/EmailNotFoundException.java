package com.ecom.users.exception.custom;

public class EmailNotFoundException extends RuntimeException{
    public EmailNotFoundException(String email){
        super("An account with email '" + email + "' does not exists.");
    }
}

package com.ecom.users.controller;

import com.ecom.users.dto.request.AuthenticateRequest;
import com.ecom.users.dto.response.AuthenicatedUserResponse;
import com.ecom.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/internal")
public class InternalAuthController {

    private final UserService userService;

    InternalAuthController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<AuthenicatedUserResponse> authenticate(@AuthenticationPrincipal UserDetails userDetails){
       return ResponseEntity.ok(this.userService.getCurrentUserInternal(userDetails.getUsername()));

    }

}

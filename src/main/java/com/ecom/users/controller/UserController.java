package com.ecom.users.controller;

import com.ecom.users.dto.request.UpdateUserRequest;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.entity.User;
import com.ecom.users.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> heathCheck(){
        return ResponseEntity.ok("Healthy");
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(this.userService.getCurrentUser(userDetails.getUsername()));
    }

    @PatchMapping("/me")
    public ResponseEntity<UserResponse> updateCurretUser(@RequestBody UpdateUserRequest updateUserRequest,
                                                         @AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(this.userService.updateCurrentUser(userDetails.getUsername(),updateUserRequest));
    }

    @DeleteMapping("/me")
    public ResponseEntity<Void> deleteUser(@AuthenticationPrincipal UserDetails userDetails){
        this.userService.deleteCurrentUser(userDetails.getUsername());
        return ResponseEntity.noContent().build();
    }
}

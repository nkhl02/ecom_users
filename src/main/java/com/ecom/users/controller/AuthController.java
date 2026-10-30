package com.ecom.users.controller;

import com.ecom.users.dto.request.RegisterUserRequest;
import com.ecom.users.dto.response.ErrorResponse;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.exception.custom.EmailAlreadyExistsException;
import com.ecom.users.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterUserRequest userRequest) {

            return ResponseEntity.ok(this.userService.registerUser(userRequest));

    }


}

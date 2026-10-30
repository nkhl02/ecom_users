package com.ecom.users.controller;

import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.entity.User;
import com.ecom.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> heathCheck(){
        return ResponseEntity.ok("Healthy");
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<UserResponse>> fetchCustomers(){
            return ResponseEntity.ok(this.userService.fetchCustomers());
    }
}

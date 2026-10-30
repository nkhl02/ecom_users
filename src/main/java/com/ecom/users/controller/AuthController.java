package com.ecom.users.controller;

import com.ecom.users.dto.request.AddressRequest;
import com.ecom.users.dto.request.RegisterUserRequest;
import com.ecom.users.dto.response.AddressResponse;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.enums.Role;
import com.ecom.users.enums.Status;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid RegisterUserRequest userRequest) {
        UserResponse response = new UserResponse(UUID.randomUUID(), userRequest.email(), userRequest.firstName(), userRequest.lastName()
                , userRequest.phoneNumber(), Role.CUSTOMER, Status.ACTIVE, LocalDateTime.now(), LocalDateTime.now(), new AddressResponse(UUID.randomUUID(), userRequest.address().recipientName(), userRequest.address().line1(), userRequest.address().line2(), userRequest.address().city(), userRequest.address().stateOrProvince(), userRequest.address().postalCode(), userRequest.address().country(), LocalDateTime.now(), LocalDateTime.now()));
        return ResponseEntity.ok(response);
    }

}

package com.ecom.users.controller;

import com.ecom.users.dto.request.UpdateUserStatusRequest;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<UserResponse>> fetchCustomers(){
        return ResponseEntity.ok(this.userService.fetchCustomers());
    }

    @GetMapping("/getAllCustomers/{page}/{size}/{sortParam}/{sortType}")
    public ResponseEntity<Page<UserResponse>> fetchCustomersPaginated(@PathVariable Integer page,
                                                                      @PathVariable Integer size,
                                                                      @PathVariable String sortParam,
                                                                      @PathVariable String sortType){
       return ResponseEntity.ok(this.userService.fetchCustomersPaginated(page,size,sortParam,sortType));
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") UUID userId){
        return ResponseEntity.ok(this.userService.getUser(userId));
    }

    @PatchMapping("/updateUserStatus/{id}")
    public ResponseEntity<UserResponse> updateUserStatus(@PathVariable("id") UUID userId, @Valid @RequestBody UpdateUserStatusRequest updateUserStatusRequest){
        return ResponseEntity.ok(this.userService.updateUserStatus(userId,updateUserStatusRequest));
    }


}

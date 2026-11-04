package com.ecom.users.service;

import com.ecom.users.dto.request.RegisterUserRequest;
import com.ecom.users.dto.request.UpdateUserRequest;
import com.ecom.users.dto.request.UpdateUserStatusRequest;
import com.ecom.users.dto.response.AuthenicatedUserResponse;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserResponse registerUser(RegisterUserRequest registerUserRequest);

    List<UserResponse> fetchCustomers();

    UserResponse getCurrentUser(String email);

    AuthenicatedUserResponse getCurrentUserInternal(String email);

    UserResponse updateCurrentUser(String username, UpdateUserRequest updateUserRequest);

    void deleteCurrentUser(String email);

    UserResponse getUser(UUID userId);

    UserResponse updateUserStatus(UUID userId, UpdateUserStatusRequest updateUserStatusRequest);

    Page<UserResponse> fetchCustomersPaginated(Integer page, Integer size, String sortParam, String sortType);
}

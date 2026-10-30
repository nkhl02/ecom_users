package com.ecom.users.service;

import com.ecom.users.dto.request.RegisterUserRequest;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.entity.User;

import java.util.List;

public interface UserService {

    UserResponse registerUser(RegisterUserRequest registerUserRequest);

    List<UserResponse> fetchCustomers();

}

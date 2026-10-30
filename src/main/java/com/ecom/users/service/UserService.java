package com.ecom.users.service;

import com.ecom.users.dto.request.RegisterUserRequest;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.entity.User;

public interface UserService {

    UserResponse registerUser(RegisterUserRequest registerUserRequest);

}

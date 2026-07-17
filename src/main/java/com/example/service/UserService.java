package com.example.service;

import com.example.dto.UserRequest;
import com.example.dto.UserResponse;

public interface UserService {

    UserResponse getUserById(long id);
    UserResponse createUser(UserRequest request);
}
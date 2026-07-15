package com.example.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.dto.UserResponse;
import com.example.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    
    @Mapping(target = "name", source = "username") //replace with the actual field name in User
    @Mapping(target = "dob", source = "dateOfBirth")
    UserResponse mapUsertoUserResponse(User user);

}

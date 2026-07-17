package com.example.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.example.dto.ContactResponse;
import com.example.dto.UserResponse;
import com.example.entity.Contact;
import com.example.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "mobileNumber", target = "mob", qualifiedByName = "maskPhoneNumber")
    @Mapping(source = "email", target = "emailId")
    ContactResponse mapContactToContactResponse(Contact contact);

    @Mapping(source = "username", target = "name")
    @Mapping(source = "dateOfBirth", target = "dob")
    @Mapping(source = "status", target = "status", defaultValue = "INACTIVE")
    @Mapping(source = "contacts", target = "contacts")
    UserResponse mapUserToUserResponse(User user);

    @Named("maskPhoneNumber")
    static String getPhoneNumber(String phone) {
        if (phone == null) {
            return null;
        }
        return phone.replaceAll(".(?=.{3})", "*");
    }
}

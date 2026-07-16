package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.dto.UserResponse;
import com.example.entity.Contact;
import com.example.entity.User;
import com.example.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;
       
    @Override
    public UserResponse getUserById(long id) {

        UserResponse userResponse = null;

        User user = userDao.findById(id).orElseThrow(() -> 
                            new ResourceNotFoundException("User not found with id: " + id));
                Contact contact = user.getContacts().stream().findFirst().orElse(null);

                userResponse = userMapper.mapUserAndContactToUserResponse(user, contact);

        return userResponse;
    }

}

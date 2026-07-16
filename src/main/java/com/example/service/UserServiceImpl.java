package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.dto.UserResponse;
import com.example.entity.Contact;
import com.example.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;
    private final ContactService contactService;
    
    @Override
    public UserResponse getUserById(long id) {

        UserResponse userResponse = null;

        User user = userDao.findById(id).orElseThrow(() -> 
            new RuntimeException("User not found!!!"));
                Contact contact = contactService.getContactById(id);

                userResponse = userMapper.mapUserAndContactToUserResponse(user, contact);

        return userResponse;
    }

}

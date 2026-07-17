package com.example.service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.dto.ContactRequest;
import com.example.dto.UserRequest;
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
        User user = userDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!!!"));
                        
        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = User.builder()
                .username(request.username())
                .password(request.password())
                .dateOfBirth(request.dateOfBirth())
                .status(request.status())
                .build();

        if (request.contacts() != null) {
            for (ContactRequest c : request.contacts()) {
                Contact contact = Contact.builder()
                        .mobileNumber(c.mobileNumber())
                        .email(c.email())
                        .build();
                user.addContact(contact);
            }
        }

        User saved = userDao.save(user);
        return userMapper.mapUserToUserResponse(saved);
    }


    @Override
    public void deleteUser(Long id) {
        User user = userDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        for (Contact contact : new HashSet<>(user.getContacts())) {
            user.getContacts().remove(contact);
            contact.getUsers().remove(user);
        }

        userDao.save(user);
        userDao.delete(user);
    }


}
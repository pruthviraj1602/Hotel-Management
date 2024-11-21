package com.User.userMicroservices.Services.IMPL;

import com.User.userMicroservices.Entities.User;
import com.User.userMicroservices.Repositories.userRepository;
import com.User.userMicroservices.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceIMPL implements userService {

    @Autowired
    private userRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.getUserByUserId(userId);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        Integer i = userRepository.deleteUserByUserId(userId);
        return i != null;
    }
}


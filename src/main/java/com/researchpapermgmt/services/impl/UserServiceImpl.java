package com.researchpapermgmt.services.impl;

import org.springframework.stereotype.Service;

import com.researchpapermgmt.models.User;
import com.researchpapermgmt.repositories.UserRepository;
import com.researchpapermgmt.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}

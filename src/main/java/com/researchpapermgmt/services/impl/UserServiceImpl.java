package com.researchpapermgmt.services.impl;

import com.researchpapermgmt.models.User;
import com.researchpapermgmt.repositories.UserRepository;
import com.researchpapermgmt.services.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}

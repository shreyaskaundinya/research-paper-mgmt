package com.researchpapermgmt.services.impl;

import org.hibernate.usertype.UserType;

import com.researchpapermgmt.enums.UserTypes;
import com.researchpapermgmt.models.User;
import com.researchpapermgmt.repositories.UserRepository;
import com.researchpapermgmt.services.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findOrCreateAuthor(String name) {
        User author = userRepository.findByName(name);
        if (author == null) {
            author = new User();
            author.setName(name);
            //author.setRole(UserTypes.AUTHOR);
            userRepository.save(author);
        }
        return author;
    }
}

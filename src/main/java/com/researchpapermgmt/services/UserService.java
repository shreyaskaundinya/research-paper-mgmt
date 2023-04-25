package com.researchpapermgmt.services;

import com.researchpapermgmt.models.User;

public interface UserService {
    User createUser(User user);
    User findOrCreateAuthor(String name);

}
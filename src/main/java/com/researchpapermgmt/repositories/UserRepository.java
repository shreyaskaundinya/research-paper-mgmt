package com.researchpapermgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchpapermgmt.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);
}

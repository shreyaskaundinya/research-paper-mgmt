package com.researchpapermgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchpapermgmt.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByName(String name);
}

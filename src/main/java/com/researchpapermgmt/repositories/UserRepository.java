package com.researchpapermgmt.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.researchpapermgmt.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);

	// @Query("SELECT u from user u where u.email = ?1")
	User findByEmail(String email);

	@Query(value = "SELECT * from user where email in ?1", nativeQuery = true)
	Set<User> findByEmailIn(Collection<String> emails);
}

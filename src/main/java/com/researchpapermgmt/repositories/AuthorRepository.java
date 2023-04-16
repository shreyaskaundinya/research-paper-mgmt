package com.researchpapermgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchpapermgmt.models.Author;


public interface AuthorRepository extends JpaRepository<Author, Long>{
	List<Author> findByName(String name);
}


package com.researchpapermgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchpapermgmt.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

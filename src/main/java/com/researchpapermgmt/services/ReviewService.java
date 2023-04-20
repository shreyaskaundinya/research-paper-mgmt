package com.researchpapermgmt.services;

import java.util.List;

import com.researchpapermgmt.models.Review;

public interface ReviewService {
    List<Review> getAllReviews();

    Review createReview(Review review);

    Review getReviewById(Long id);

    List<Review> getReviewsByPaperId(Long id);
}

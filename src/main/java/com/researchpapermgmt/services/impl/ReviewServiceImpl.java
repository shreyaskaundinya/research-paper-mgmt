package com.researchpapermgmt.services.impl;

import java.util.List;

import com.researchpapermgmt.models.Review;
import com.researchpapermgmt.repositories.ReviewRepository;
import com.researchpapermgmt.services.ReviewService;

public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    public Review createReview(Review review) {
        return this.reviewRepository.save(review);
    }

    public Review getReviewById(Long id) {
        // TODO : To be implemented
        return null;
    }

    public List<Review> getReviewsByPaperId(Long id) {
        // TODO : To be implemented
        return null;
    }
}

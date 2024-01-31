package com.example.reviews.Services.Impl;


import com.example.reviews.Models.Entites.Review;
import com.example.reviews.Repositories.ReviewRepository;
import com.example.reviews.Services.IReview;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ReviewServiceImpl implements IReview {
    private final ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(UUID id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        reviewRepository.deleteById(id);
    }
}

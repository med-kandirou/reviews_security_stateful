package com.example.reviews.Services.Impl;


import com.example.reviews.Models.Entites.Review;
import com.example.reviews.Repositories.ReviewRepository;
import com.example.reviews.Services.IReview;
import com.example.reviews.exception.ResourceNotFoundException;
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
        return reviewRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("id review : " + id));
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review delete(UUID id) {
        Review review=reviewRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("id review : " + id));
        reviewRepository.deleteById(id);
        return review;
    }
}

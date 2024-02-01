package com.example.reviews.Services;

import com.example.reviews.Models.Entites.Review;

import java.util.List;
import java.util.UUID;

public interface IReview {
    Review save(Review review);

    Review findById(UUID id);

    List<Review> getAll();

    Review delete(UUID id);
}

package com.example.reviews.Repositories;

import java.util.UUID;


import com.example.reviews.Models.Entites.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    
}

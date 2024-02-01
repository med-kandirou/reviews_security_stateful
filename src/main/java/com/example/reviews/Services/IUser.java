package com.example.reviews.Services;

import com.example.reviews.Models.Entites.Review;
import com.example.reviews.Models.Entites.User;

import java.util.List;
import java.util.UUID;

public interface IUser {
    User save(User User);

    User findById(UUID id);

    List<User> getAll();

    User delete(UUID id);
}

package com.example.reviews.Services.Impl;

import com.example.reviews.Models.Entites.User;
import com.example.reviews.Repositories.UserRepository;
import com.example.reviews.Services.IUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements IUser {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User User) {
        return null;
    }

    @Override
    public User findById(UUID id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}

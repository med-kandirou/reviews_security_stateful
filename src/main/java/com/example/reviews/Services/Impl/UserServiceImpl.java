package com.example.reviews.Services.Impl;


import com.example.reviews.Models.Entites.User;
import com.example.reviews.Repositories.UserRepository;
import com.example.reviews.Services.IUser;
import com.example.reviews.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements IUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("id review : " + id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User delete(UUID id) {
        User user=userRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("id review : " + id));
        userRepository.deleteById(id);
        return user;
    }
}

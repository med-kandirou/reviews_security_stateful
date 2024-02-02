package com.example.reviews.Services;

import com.example.reviews.Models.Entites.User;
import com.example.reviews.Repositories.UserRepository;
import com.example.reviews.configs.UserInfosUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserInfosUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfos = userRepository.findByUsername(username);

        return userInfos.map(UserInfosUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found "+username));
    }
}

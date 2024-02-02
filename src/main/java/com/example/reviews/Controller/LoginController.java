package com.example.reviews.Controller;

import com.example.reviews.Models.Entites.User;
import com.example.reviews.Services.IUser;
import com.example.youreview.Models.Enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private IUser userService;

    @Autowired
    public LoginController(IUser userService)
    {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/newUser")
    public String addUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setRole(Role.USER);
        userService.save(user);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(Role.ADMIN);
        userService.save(admin);


        User moderator = new User();
        moderator.setUsername("moderator");
        moderator.setPassword("moderator");
        moderator.setRole(Role.MODERATOR);
        userService.save(moderator);


        return "loginPage";
    }

}

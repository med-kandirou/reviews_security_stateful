package com.example.reviews.Controller;


import com.example.reviews.Models.Entites.User;
import com.example.reviews.Services.IUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IUser iuser;

    public UserController(IUser iuser) {
        this.iuser = iuser;
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("User", new User());
        return "createUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        iuser.save(user);
        return "redirect:/Users";
    }

    @GetMapping("/{id}")
    public String showUserDetails(@PathVariable UUID id, Model model) {
        User user = iuser.findById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "UserDetails";
        } else {
            return "notFound";
        }
    }

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> users = iuser.getAll();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable UUID id) {
        iuser.delete(id);
        return "redirect:/Users";
    }
}

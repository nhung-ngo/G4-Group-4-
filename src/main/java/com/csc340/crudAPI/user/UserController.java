package com.csc340.crudAPI.user;
import com.csc340.crudAPI.Review.ReviewService;
import com.csc340.crudAPI.service.SerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("reviewList", reviewService.getAllReviews()); // Review list
        return "admin-management";
    }

    @PostMapping("/ban/{userId}")
    public String banUser(@PathVariable Long userId) {
        userService.banUser(userId);
        return "redirect:/users/all";
    }

    @PostMapping("/unban/{userId}")
    public String unbanUser(@PathVariable Long userId) {
        userService.unbanUser(userId);
        return "redirect:/users/all";
    }


    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userService.getUserById((long) userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }

    @GetMapping("/email")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}


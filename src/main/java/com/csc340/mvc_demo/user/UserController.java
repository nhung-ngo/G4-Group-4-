package com.csc340.mvc_demo.user;
import com.csc340.mvc_demo.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserRepository userRepository;
    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String handleLogin(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.authenticate(email, password);
        if (user != null) {
            String status = user.getStatus();
            if(!status.equals("banned")) {
                int userId = user.getUserId();
                model.addAttribute("userId", userId);
                model.addAttribute("user", user);
                return "redirect:/services/home?userId=" + userId; // Redirect to the dashboard or another page
            }
           else {
               model.addAttribute("error", "This account is banned");
                return "user/login";
           }
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "user/login";
        }
    }

    // Display the sign-up page
    @GetMapping("/signup")
    public String showSignUpPage() {
        return "user/signup";
    }

    // Handle sign-up form submission
    @PostMapping("/signup")
    public String handleSignUp(@RequestParam String name, @RequestParam String email,
                               @RequestParam String password, Model model) {

        User user = new User(name, email, password);
        if (userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("message","Email already in use.");
            return "user/signup";
        }
        user.setStatus("active"); // Set default status to "active"
        userService.saveUser(user);
        return "user/login";
    }
    @GetMapping("/logout")
    public String logout() {
        // Add any session clearing logic here, if needed
        return "redirect:/users/login";
    }
    @GetMapping("/profile")
    public String getUserProfile(Model model, @RequestParam("userId") int userId) {
        User user = userService.getUserById(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("user", user);
        return "user/profile";
    }

    // Display the user update page
    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam("userId") int userId, Model model) {
        // Retrieve the user by ID
        User user = userService.getUserById(userId);
        model.addAttribute("userId", userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user ID: " + userId);
        }

        // Add user data to the model

        model.addAttribute("user", user);

        // Return the update view
        return "user/update"; // Name of the Thymeleaf template file (user-update.html)
    }

    @PostMapping("/update")
    public String updateUser( User user, Model model) {
        int userId = user.getUserId();
        model.addAttribute("userId", userId);
        userService.updateUser(user); // Update the user in the database
        model.addAttribute("message", "Profile updated successfully!");
        return "redirect:/users/profile?userId=" + userId; // Redirect to the profile page
    }

    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId); // Implement this in your service
        return "redirect:/users/login";
    }


    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("reviewList", reviewService.getAllReviews()); // Review list
        return "admin/admin-management";
    }

    @PostMapping("/ban/{userId}")
    public String banUser(@PathVariable int userId) {
        userService.banUser(userId);
        return "redirect:/users/all";
    }

    @PostMapping("/unban/{userId}")
    public String unbanUser(@PathVariable int userId) {
        userService.unbanUser(userId);
        return "redirect:/users/all";
    }



    @GetMapping("/email")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}


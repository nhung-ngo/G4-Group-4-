package com.csc340.crudAPI.user;
import com.csc340.crudAPI.Review.ReviewService;
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
            int userId = user.getUserId();
            model.addAttribute("userId", userId);
            model.addAttribute("user", user);
            return "redirect:/services/home"; // Redirect to the dashboard or another page
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
        user.setStatus("active"); // Set default status to "active"
        userService.saveUser(user);
        model.addAttribute("message", "Account created successfully. Please log in.");
        return "redirect:/users/login";
    }
    @GetMapping("/logout")
    public String logout() {
        // Add any session clearing logic here, if needed
        return "redirect:/users/login";
    }

    @GetMapping("/ADMIN/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("reviewList", reviewService.getAllReviews()); // Review list
        return "admin-management";
    }

    @PostMapping("/ban/{userId}")
    public String banUser(@PathVariable int userId) {
        userService.banUser(userId);
        return "redirect:/ADMIN/all";
    }

    @PostMapping("/unban/{userId}")
    public String unbanUser(@PathVariable int userId) {
        userService.unbanUser(userId);
        return "redirect:/ADMIN/all";
    }





    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }



    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }

    @DeleteMapping("/{userId}")
    public List<User> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return userService.getAllUsers();
    }

    @GetMapping("/email")
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}


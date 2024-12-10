package com.csc340.mvc_demo.user;

import com.csc340.mvc_demo.Booking.BookingRepository;
import com.csc340.mvc_demo.Reply.ReplyRepository;
import com.csc340.mvc_demo.Review.ReviewRepository;
import com.csc340.mvc_demo.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    @Autowired
    private  UserRepository userRepository;



    public User authenticate(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + user.getUserId()));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(user.getPassword());
        }
        userRepository.save(existingUser);
    }


    public void deleteUser(int userId) {
        userRepository.deleteById(userId);

    }

    public List<User> findUsersByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    public void banUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setStatus("banned");
        userRepository.save(user);
    }

    public void unbanUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setStatus("active");
        userRepository.save(user);
    }

}

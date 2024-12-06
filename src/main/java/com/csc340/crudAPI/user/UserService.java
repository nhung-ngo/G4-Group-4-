package com.csc340.crudAPI.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
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

    public User updateUser(int userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setStatus(userDetails.getStatus());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
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

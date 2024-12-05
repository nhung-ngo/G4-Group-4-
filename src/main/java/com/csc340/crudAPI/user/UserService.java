package com.csc340.crudAPI.user;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById((long) userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int userId, User userDetails) {
        return userRepository.findById((long) userId).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setStatus(userDetails.getStatus());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    }

    public void save(User user) {
        userRepository.save(user);
    }


    public void deleteUser(int userId) {
        userRepository.deleteById((long) userId);
    }
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void banUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setStatus("banned");
        userRepository.save(user);
    }

    public void unbanUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setStatus("active");
        userRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.csc340.crudAPI.user.User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole()) // This automatically prefixes with "ROLE_"
                .build();
    }
}

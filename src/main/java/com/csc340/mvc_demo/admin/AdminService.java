package com.csc340.mvc_demo.admin;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin authenticate(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password)
                .orElse(null); // Null if authentication fails
    }
}

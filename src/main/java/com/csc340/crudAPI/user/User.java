package com.csc340.crudAPI.user;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String password;
    private String status;

//    @Column(nullable = false)
//    private String role; // Either "ADMIN" or "CUSTOMER"


    // Constructors, Getters, and Setters


    public User() {}

    public User(String name, String email, String password, String status, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
//        this.role = role;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = (long) userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
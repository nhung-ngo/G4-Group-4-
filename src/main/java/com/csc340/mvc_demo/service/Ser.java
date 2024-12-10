package com.csc340.mvc_demo.service;

import com.csc340.mvc_demo.Booking.Booking;
import com.csc340.mvc_demo.Review.Review;
import com.csc340.mvc_demo.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Service")
public class Ser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    private String title;
    private String imagePath;
    private double price;
    private String description;
    private String location;
    private String category;
    private String status;

    // Constructors, Getters, and Setters

    public Ser() {}

    public Ser(int serviceId, User user, String title, String imagePath, double price, String description, String location, String category, String status) {
        this.serviceId= serviceId;
        this.user = user;
        this.title = title;
        this.imagePath = imagePath;
        this.price = price;
        this.description = description;
        this.location = location;
        this.category = category;
        this.status = status;
    }

    public Ser(User user, String title, String imagePath, double price, String description, String location, String category, String status) {
        this.user = user;
        this.title = title;
        this.imagePath = imagePath;
        this.price = price;
        this.description = description;
        this.location = location;
        this.category = category;
        this.status = status;
    }
    public Ser( Ser service) {
        this.serviceId= serviceId;
        this.user = user;
        this.title = title;
        this.imagePath = imagePath;
        this.price = price;
        this.description = description;
        this.location = location;
        this.category = category;
        this.status = status;
    }
    public Ser( Ser service, User user) {
        this.serviceId= serviceId;
        this.user = user;
        this.title = title;
        this.imagePath = imagePath;
        this.price = price;
        this.description = description;
        this.location = location;
        this.category = category;
        this.status = status;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


package com.csc340.crudAPI.Review;

import com.csc340.crudAPI.Reply.Reply;
import com.csc340.crudAPI.service.Ser;
import com.csc340.crudAPI.user.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewID;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user; // Reference to the parent review4

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Ser service; // Reference to the parent review

    @Column
    private String reviews; // Nullable field

    @Column(nullable = false)
    private int rating;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies; // List of associated replies


    public Review() {

    }
    public Review(int rating, String reviews, Ser service, User user) {
        this.rating = rating;
        this.reviews = reviews;
        this.service = service;
        this.user = user;
    }

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ser getService() {
        return service;
    }

    public void setService(Ser service) {
        this.service = service;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }


    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


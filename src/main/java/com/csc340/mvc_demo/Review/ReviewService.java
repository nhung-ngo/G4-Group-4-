package com.csc340.mvc_demo.Review;

import com.csc340.mvc_demo.Reply.ReplyRepository;
import com.csc340.mvc_demo.service.Ser;
import com.csc340.mvc_demo.service.SerService;
import com.csc340.mvc_demo.user.User;
import com.csc340.mvc_demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private SerService serviceService;
    @Autowired
    private UserService userService;

    public Ser getServiceByReviewId(int reviewId) {
        return reviewRepository.findServiceByReviewId(reviewId);
    }

    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByServiceID(int serviceID) {
        return reviewRepository.findByServiceID(serviceID);
    }


    public void deleteReviewById(int reviewID) {
        replyRepository.deleteByReviewId(reviewID);
        reviewRepository.deleteById(reviewID);
    }

    public void addReview(int serviceId, int userId, int rating, String reviews) {
        Ser service = serviceService.getServiceById(serviceId);
        User user = userService.getUserById(userId);

        if (service == null) {
            throw new IllegalArgumentException("Service with ID " + serviceId + " not found.");
        }

        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }

        Review review = new Review(rating, reviews, service, user);
        reviewRepository.save(review);
    }

    public List<Review> findReviewsByUserName(String name) {
        return reviewRepository.findReviewsByUserName(name);
    }

    public int countTotalReviewsForService(int serviceId) {
        return reviewRepository.countTotalReviewsForAService(serviceId);
    }
}


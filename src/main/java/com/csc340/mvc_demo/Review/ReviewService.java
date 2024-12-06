package com.csc340.mvc_demo.Review;

import com.csc340.mvc_demo.Reply.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReplyRepository replyRepository;

    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByServiceID(int serviceID) {
        return reviewRepository.findByServiceID(serviceID);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReviewById(int reviewID) {
        replyRepository.deleteByReviewId(reviewID);
        reviewRepository.deleteById(reviewID);
    }

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }


}


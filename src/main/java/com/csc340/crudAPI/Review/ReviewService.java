package com.csc340.crudAPI.Review;

import com.csc340.crudAPI.Reply.ReplyRepository;
import com.csc340.crudAPI.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReplyRepository replyRepository;



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


}


package com.csc340.crudAPI.Review;

import com.csc340.crudAPI.Reply.Reply;
import com.csc340.crudAPI.Reply.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReplyService replyService;

    @GetMapping("/services/{serviceID}")
    public List<Review> getReviewsByServiceID(@PathVariable int serviceID) {
        return reviewService.getReviewsByServiceID(serviceID);
    }

    // GET all replies for a specific review
    @GetMapping("/{reviewID}/replies")
    public List<Reply> getRepliesByReviewId(@PathVariable int reviewID) {
        return replyService.getRepliesByReviewId(reviewID);
    }

    // GET all reviews
    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @DeleteMapping("/{reviewID}")
    public List<Review> deleteReviewById(@PathVariable int reviewID) {
        reviewService.deleteReviewById(reviewID);
        return reviewService.getAllReviews();

    }


    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }
}



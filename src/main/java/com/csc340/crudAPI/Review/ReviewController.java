package com.csc340.crudAPI.Review;

import com.csc340.crudAPI.Reply.Reply;
import com.csc340.crudAPI.Reply.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String getAllReviews(Model model) {
        model.addAttribute("reviewList", reviewService.getAllReviews()); // Add reviews to the model
        return "admin-management"; // Name of the Thymeleaf template
    }
    @PostMapping("/delete/{reviewId}")
    public String deleteReview(@PathVariable("reviewId") int reviewID) {
        reviewService.deleteReviewById(reviewID); // Correct method usage
        return "redirect:/users/all"; // Redirect to review list
    }


    @DeleteMapping("/{reviewID}")
    public void deleteReviewById(@PathVariable int reviewID) {
        reviewService.deleteReviewById(reviewID);
    }
    @DeleteMapping("/replies/{replyID}")
    public void deleteReplyById(@PathVariable int replyID) {
        replyService.deleteReplyById(replyID);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }
}



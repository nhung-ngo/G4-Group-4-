package com.csc340.mvc_demo.Review;

import com.csc340.mvc_demo.Reply.Reply;
import com.csc340.mvc_demo.Reply.ReplyService;
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
    // POST a reply to a specific review
    @PostMapping("/{reviewID}/reply")
    public String createReplyForReview(@PathVariable int reviewID,
                                       @RequestParam String content,
                                       @RequestParam int serviceID,
                                       Model model) {
        // Create a new reply object and associate it with the review
        Reply reply = new Reply(content, reviewService.getReviewById(reviewID));

        // Save the reply and retrieve the updated list of replies

        // Fetch the service details and reviews again to refresh the page
        model.addAttribute("service", reviewService.getReviewsByServiceID(serviceID));
        List<Review> reviews = reviewService.getReviewsByServiceID(serviceID);
        model.addAttribute("reviews", reviews);
        for (Review review : reviews) {
            int reviewId = review.getReviewID();
            List<Reply> replies = replyService.getRepliesByReviewId(reviewId);
            model.addAttribute("replies_" + reviewId, replies);
        }

        // Redirect back to the service details page
        return "redirect:/reviews/services/" + serviceID;
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
        return "redirect:/ADMIN/all"; // Redirect to review list
    }


}


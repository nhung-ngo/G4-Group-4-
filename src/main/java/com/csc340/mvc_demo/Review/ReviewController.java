package com.csc340.mvc_demo.Review;

import com.csc340.mvc_demo.Reply.Reply;
import com.csc340.mvc_demo.Reply.ReplyService;
import com.csc340.mvc_demo.service.Ser;
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

    @GetMapping("/{reviewID}")
    public String getReviewDetails(@PathVariable int reviewID, Model model) {
        Review review = reviewService.getReviewById(reviewID);
        List<Reply> replies = replyService.getRepliesByReviewId(reviewID);
        Ser service = reviewService.getServiceByReviewId(reviewID);
        model.addAttribute("service", service);
        model.addAttribute("review", review);
        model.addAttribute("replies", replies);
        model.addAttribute("title", "Review Details");

        return "provider/review-details"; // Thymeleaf template for review details
    }

    @PostMapping("/reviews")
    public String postReview(@RequestParam("serviceId") int serviceId,
                             @RequestParam("userId") int userId,
                             @RequestParam("rating") int rating,
                             @RequestParam("reviews") String reviews,
                             Model model) {
        try {
            reviewService.addReview(serviceId, userId, rating, reviews);
            model.addAttribute("success", "Review posted successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Error posting review: " + e.getMessage());
        }
        return "redirect:/services/" + serviceId + "/user/" + userId;
    }



    // GET all reviews
    @GetMapping("/all")
    public String getAllReviews(Model model) {
        model.addAttribute("reviewList", reviewService.getAllReviews()); // Add reviews to the model
        return "admin/admin-management"; // Name of the Thymeleaf template
    }
    @PostMapping("/delete/{reviewId}")
    public String deleteReview(@PathVariable("reviewId") int reviewID) {
        reviewService.deleteReviewById(reviewID); // Correct method usage
        return "redirect:/users/all"; // Redirect to review list
    }


}


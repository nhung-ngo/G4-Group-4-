package com.csc340.mvc_demo.Reply;

import com.csc340.mvc_demo.Review.Review;
import com.csc340.mvc_demo.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private ReviewService reviewService;

    /**
     * Fetch replies for a specific review.
     */
    @GetMapping("/review/{reviewId}")
    public String getRepliesByReview(@PathVariable("reviewId") int reviewId, Model model) {
        try {
            List<Reply> replies = replyService.getRepliesByReviewId(reviewId);
            model.addAttribute("replies", replies);
            model.addAttribute("review", reviewService.getReviewById(reviewId));
            return "provider/review-details";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    /**
     * Add a new reply to a review.
     */
    @PostMapping("/review/{reviewId}")
    public String addReply(@PathVariable("reviewId") int reviewId,
                           @RequestParam("content") String content,
                           Model model) {
        Review review = reviewService.getReviewById(reviewId);
        Reply reply = new Reply(content, review);
        try {
            replyService.createReplyForReview(reviewId, reply);
            model.addAttribute("success", "Reply added successfully.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/reviews/" + reviewId;
    }

    /**
     * Delete a reply by ID.
     */
    @GetMapping("/delete/{replyId}")
    public String deleteReply(@PathVariable("replyId") int replyId,
                              Model model) {
        Reply reply = replyService.getReplyById(replyId);
        int reviewId = reply.getReview().getReviewID();
        try {
            replyService.deleteReplyById(replyId);
            model.addAttribute("success", "Reply deleted successfully.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/reviews/" + reviewId;
    }

}




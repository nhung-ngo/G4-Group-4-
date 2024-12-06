package com.csc340.crudAPI.Reply;

import com.csc340.crudAPI.Review.Review;
import com.csc340.crudAPI.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReviewService reviewService;
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }
    public List<Reply> getRepliesByReviewId(int reviewID) {
        return replyRepository.findByReviewReviewID(reviewID);
    }

    public Reply createReplyForReview(int reviewID, Reply reply) {
        // Fetch the review by ID
        Review reviewOptional = reviewService.getReviewById(reviewID);

            reply.setReview(reviewOptional);
            return replyRepository.save(reply);

    }

    // Delete a reply by its ID
    public void deleteReplyById(int replyID) {
        replyRepository.deleteById(replyID);
    }
}


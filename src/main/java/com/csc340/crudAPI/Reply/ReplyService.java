package com.csc340.crudAPI.Reply;

import com.csc340.crudAPI.Review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }
    public List<Reply> getRepliesByReviewId(int reviewID) {
        return replyRepository.findByReviewReviewID(reviewID);
    }

    public void deleteReplyById(int replyID) {
        replyRepository.deleteById(replyID);
    }

    public Reply addReplyToReview(Reply reply) {
        return replyRepository.save(reply);
    }
}


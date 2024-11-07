package com.csc340.crudAPI.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;
    @GetMapping("/all")
    public List<Reply> getAllReplies() {
        return replyService.getAllReplies();
    }

    // GET all replies for a specific review
    @GetMapping("/review/{reviewID}")
    public List<Reply> getRepliesByReviewId(@PathVariable int reviewID) {
        return replyService.getRepliesByReviewId(reviewID);
    }

    // DELETE a specific reply
    @DeleteMapping("/{replyID}")
    public List<Reply> deleteReply(@PathVariable int replyID) {
        replyService.deleteReplyById(replyID);
        return replyService.getAllReplies();
    }

    @PostMapping
    public Reply addReplyToReview(@RequestBody Reply reply){
        return replyService.addReplyToReview(reply);

    }
}




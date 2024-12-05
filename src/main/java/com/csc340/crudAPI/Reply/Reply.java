package com.csc340.crudAPI.Reply;

import com.csc340.crudAPI.Review.Review;
import jakarta.persistence.*;

@Entity
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyID;

    private String content;
    @ManyToOne
    @JoinColumn(name = "reviewid", referencedColumnName = "reviewID")
    private Review review; // Reference to the parent review

    public Reply() {

    }
    public Reply(String content, Review review) {
        this.content = content;
        this.review = review;
    }

    // Getters and setters

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}


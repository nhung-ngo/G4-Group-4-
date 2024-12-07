package com.csc340.mvc_demo.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    List<Reply> findByReviewReviewID(int reviewID);
    void deleteByReviewReviewID(int reviewID);

    @Modifying
    @Transactional
    @Query("DELETE FROM Reply r WHERE r.review.reviewID = :reviewId")
    void deleteByReviewId(@Param("reviewId") int reviewId);

    @Query("SELECT COUNT(rep) FROM Reply rep")
    int countTotalReplies();


}


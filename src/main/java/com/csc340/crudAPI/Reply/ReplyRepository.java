package com.csc340.crudAPI.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    List<Reply> findByReviewReviewID(int reviewID);
    void deleteByReviewReviewID(int reviewID);



    @Query("SELECT COUNT(rep) FROM Reply rep")
    int countTotalReplies();
}


package com.csc340.mvc_demo.Review;

import com.csc340.mvc_demo.service.Ser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "select * from reviews where service_id = ?1", nativeQuery = true )
    List<Review> findByServiceID(int serviceID);

    @Query("SELECT r.service FROM Review r WHERE r.reviewID = :reviewId")
    Ser findServiceByReviewId(@Param("reviewId") int reviewId);

    @Query("SELECT COUNT(r) FROM Review r")
    int countTotalReviews();

    @Query("SELECT r FROM Review r WHERE LOWER(r.user.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Review> findReviewsByUserName(@Param("name") String name);

    @Query(value =  "SELECT COUNT(reviewid) FROM reviews where service_id=?1 ", nativeQuery = true)
    int countTotalReviewsForAService(int serviceid);
}


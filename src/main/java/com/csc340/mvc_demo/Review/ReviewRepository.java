package com.csc340.mvc_demo.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "select * from reviews where service_id = ?1", nativeQuery = true )
    List<Review> findByServiceID(int serviceID);



    @Query("SELECT COUNT(r) FROM Review r")
    int countTotalReviews();
}


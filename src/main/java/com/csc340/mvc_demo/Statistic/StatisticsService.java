package com.csc340.mvc_demo.Statistic;

import com.csc340.mvc_demo.Booking.BookingRepository;
import com.csc340.mvc_demo.Reply.ReplyRepository;
import com.csc340.mvc_demo.Review.ReviewRepository;
import com.csc340.mvc_demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReplyRepository replyRepository;



    public int getTotalUsers() {
        return userRepository.countTotalUsers();
    }

    // Get number of users who have chosen a service
    public int getTotalBookingForAService(int serviceid) {
        return bookingRepository.countTotalBookingForAService(serviceid);
    }

    public int getTotalBooking() {
        return bookingRepository.countTotalBooking();
    }


    // Get total number of reviews
    public int getTotalReviews() {
        return reviewRepository.countTotalReviews();
    }

    // Get total number of replies
    public int getTotalReplies() {
        return replyRepository.countTotalReplies();
    }
}


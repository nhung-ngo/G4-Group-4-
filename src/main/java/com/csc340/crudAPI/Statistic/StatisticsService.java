package com.csc340.crudAPI.Statistic;

import com.csc340.crudAPI.Booking.BookingRepository;
import com.csc340.crudAPI.Reply.ReplyRepository;
import com.csc340.crudAPI.Review.ReviewRepository;
import com.csc340.crudAPI.service.ServiceRepository;
import com.csc340.crudAPI.user.UserRepository;
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
        return (int) userRepository.count(); // Example: count all users
    }

    public int getTotalBooking() {
        return bookingRepository.countTotalBooking(); // Example: count bookings by service
    }

    public int getTotalReviews() {
        return (int) reviewRepository.count(); // Count all reviews
    }

    public int getTotalReplies() {
        return (int) replyRepository.count(); // Count all replies
    }
}



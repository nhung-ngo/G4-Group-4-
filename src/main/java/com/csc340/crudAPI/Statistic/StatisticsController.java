package com.csc340.crudAPI.Statistic;

import com.csc340.crudAPI.Reply.ReplyService;
import com.csc340.crudAPI.Review.ReviewRepository;
import com.csc340.crudAPI.Review.ReviewService;
import com.csc340.crudAPI.service.SerService;
import com.csc340.crudAPI.service.ServiceRepository;
import com.csc340.crudAPI.user.UserRepository;
import com.csc340.crudAPI.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticService;



    @GetMapping("/total-users")
    public int getTotalUsers() {
        return statisticService.getTotalUsers();
    }

    // Endpoint to get number of users who have chosen a service
    @GetMapping("/totalBooking")
    public int getTotalBooking(@RequestParam(name="service_id",defaultValue = "1") int serviceId) {
        return statisticService.getTotalBooking(serviceId);
    }

    // Endpoint to get total number of reviews
    @GetMapping("/total-reviews")
    public int getTotalReviews() {
        return statisticService.getTotalReviews();
    }

    // Endpoint to get total number of replies
    @GetMapping("/total-replies")
    public int getTotalReplies() {
        return statisticService.getTotalReplies();
    }
}




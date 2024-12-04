package com.csc340.crudAPI.Statistic;

import com.csc340.crudAPI.Reply.ReplyService;
import com.csc340.crudAPI.Review.ReviewRepository;
import com.csc340.crudAPI.Review.ReviewService;
import com.csc340.crudAPI.service.SerService;
import com.csc340.crudAPI.service.ServiceRepository;
import com.csc340.crudAPI.user.UserRepository;
import com.csc340.crudAPI.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stats")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticService;

    @GetMapping("/overview")
    public String getStatisticsOverview(Model model) {
        model.addAttribute("totalUsers", statisticService.getTotalUsers());
        model.addAttribute("totalBookings", statisticService.getTotalBooking());
        model.addAttribute("totalReviews", statisticService.getTotalReviews());
        model.addAttribute("totalReplies", statisticService.getTotalReplies());
        return "statistic";
    }
}





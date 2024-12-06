package com.csc340.mvc_demo.Statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticService;



    @GetMapping("/stats/overview")
    public String getStatisticsOverview(Model model) {
        model.addAttribute("totalUsers", statisticService.getTotalUsers());
        model.addAttribute("totalBookings", statisticService.getTotalBooking());
        model.addAttribute("totalReviews", statisticService.getTotalReviews());
        model.addAttribute("totalReplies", statisticService.getTotalReplies());
        model.addAttribute("totalServices", statisticService.getTotalServices());
        return "admin/statistic";
    }




}




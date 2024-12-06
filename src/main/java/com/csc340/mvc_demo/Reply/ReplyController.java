package com.csc340.mvc_demo.Reply;

import com.csc340.mvc_demo.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private ReviewService reviewService;


}




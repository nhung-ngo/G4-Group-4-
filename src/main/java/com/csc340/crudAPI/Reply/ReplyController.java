package com.csc340.crudAPI.Reply;

import com.csc340.crudAPI.Review.ReviewService;
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




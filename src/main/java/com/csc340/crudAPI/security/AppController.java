package com.csc340.crudAPI.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/", "/home", "/app"})
    public String home() {
        return "redirect:/statistics"; // Redirect to your desired default page
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String showError() {
        return "error";
    }
}

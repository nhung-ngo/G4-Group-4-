package com.csc340.mvc_demo.admin;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "admin/admin-login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        Admin admin = adminService.authenticate(username, password); // Authentication logic
        if (admin != null) {
            int adminId = admin.getAdminId();
            model.addAttribute("adminId", adminId);
            return "redirect:/stats/overview"; // Render a success page
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/admin/login"; // Reload the login page with an error message
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the current session
        session.invalidate();
        // Redirect to the admin login page
        return "redirect:/admin/login";
    }
}

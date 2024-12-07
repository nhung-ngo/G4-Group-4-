package com.csc340.mvc_demo.service;

import com.csc340.mvc_demo.Reply.ReplyService;
import com.csc340.mvc_demo.Review.Review;
import com.csc340.mvc_demo.Review.ReviewService;
import com.csc340.mvc_demo.user.User;
import com.csc340.mvc_demo.user.UserRepository;
import com.csc340.mvc_demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {


    @Autowired
    private ReplyService replyService;
    @Autowired
    private SerService serviceService;

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;


    //User
    // Get all services

    @GetMapping("/home")
    public String getAllServices(@RequestParam("userId") int userId, Model model) {
        List<Ser> serviceList = serviceRepository.findAll();
        model.addAttribute("userId", userId);
        model.addAttribute("serviceList", serviceList);  // Passing services to the view
        model.addAttribute("title", "All Services");
        return "user/home";  // Returning the name of your template
    }

    @GetMapping("/{serviceId}/user/{userId}")
    public String getServiceDetails(@PathVariable int serviceId, @PathVariable int userId, Model model) {
        Ser service = serviceService.getServiceById(serviceId);
        model.addAttribute("userId",userId);
        model.addAttribute("service", service);
        List<Review> reviews = reviewService.getReviewsByServiceID(serviceId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("title", "Service Details");
        return "user/service-details"; // Renders service-details.html
    }






    //provider
    @GetMapping("/user")
    public String getAllServicesByUserId(@RequestParam("userId") int userId, Model model) {
        List<Ser> serviceList = serviceService.getServicesByUserId(userId);

        model.addAttribute("serviceList", serviceList);  // Passing services to the view
        model.addAttribute("userId", userId);
        return "provider/services-all";  // Returning the name of your template
    }
    /**
     * Get a specific service by its ID.
     * <a href="http://localhost:8080/services/{serviceId}">Service Details</a>
     */
    @GetMapping("/{serviceId}")
    public String getServiceById(@PathVariable int serviceId, Model model) {
        int userId = serviceService.getServiceById(serviceId).getUser().getUserId();
        model.addAttribute("userId", userId);
        model.addAttribute("service", serviceService.getServiceById(serviceId));
        List<Review> reviews = reviewService.getReviewsByServiceID(serviceId);
        model.addAttribute("reviews", reviews);
        model.addAttribute("title", "Service Details");
        return "provider/service-details"; // Render service-details.html
    }

    /**
     * Display the form for creating a new service.
     * <a href="http://localhost:8080/services/create">Create New Service</a>
     */
    @GetMapping("/create")
    public String showCreateForm(@RequestParam("userId") int userId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("service", new Ser());
        return "provider/service-create";
    }

    /**
     * Handle the submission of the create form.
     * <a href="http://localhost:8080/services/new">Submit New Service</a>
     */
    @PostMapping("/new/{userId}")
    public String createService(@ModelAttribute Ser service, @PathVariable int userId) {
        User user = userService.getUserById(userId);
        serviceService.createService(service, user);
        return "redirect:/services/user?userId=" + userId;
    }

    /**
     * Display the update form for a specific service.
     * <a href="http://localhost:8080/services/update/{serviceId}">Update Service</a>
     */
    @GetMapping("/update/{serviceId}")
    public String showUpdateForm(@PathVariable int serviceId, Model model) {
        int userId = serviceService.getServiceById(serviceId).getUser().getUserId();
        model.addAttribute("userId", userId);
        model.addAttribute("service", serviceService.getServiceById(serviceId)); // Populate with existing data
        return "provider/service-update"; // Reusing the service-update.html template for both create and edit
    }

    /**
     * Handle the submission of the update form.
     */
    @PostMapping("/update")
    public String updateService(@ModelAttribute Ser service) {
        Ser existing= serviceService.getServiceById(service.getServiceId());
        service.setUser(existing.getUser());
        serviceService.updateService(service.getServiceId(), service); // Update the existing service
        return "redirect:/services/" + service.getServiceId(); // Redirect to the service details page
    }

    /**
     * Delete a service by its ID.
     * <a href="http://localhost:8080/services/delete/{serviceId}">Delete Service</a>
     */
    @GetMapping("/delete/{serviceId}")
    public String deleteServiceById(@PathVariable int serviceId) {
        int userId = serviceService.getServiceById(serviceId).getUser().getUserId();
        serviceService.deleteService(serviceId);
        return "redirect:/services/user?userId=" + userId; // Redirect to the list of services after deletion
    }

}
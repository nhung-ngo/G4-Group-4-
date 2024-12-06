package com.csc340.crudAPI.service;

import com.csc340.crudAPI.Reply.ReplyService;
import com.csc340.crudAPI.Review.Review;
import com.csc340.crudAPI.Review.ReviewService;
import com.csc340.crudAPI.user.User;
import com.csc340.crudAPI.user.UserRepository;
import com.csc340.crudAPI.user.UserService;
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
    public String getAllServices(Model model) {
        List<Ser> serviceList = serviceRepository.findAll();

        model.addAttribute("serviceList", serviceList);  // Passing services to the view
        model.addAttribute("title", "All Services");
        return "user/home";  // Returning the name of your template
    }

    @GetMapping("/user/{serviceId}")
    public String getServiceDetails(@PathVariable int serviceId, Model model) {
        Ser service = serviceService.getServiceById(serviceId);
        model.addAttribute("service", service);
        model.addAttribute("title", "Service Details");
        return "user/service-details"; // Renders service-details.html
    }

    @PostMapping("/user/{serviceId}/reserve")
    public String makeReservation(@PathVariable int serviceId,
                                  @RequestParam String reservationDate,
                                  @RequestParam int guests,
                                  Model model) {
        // Logic for making a reservation
        Ser service = serviceService.getServiceById(serviceId);

        // Add reservation confirmation to the model
        model.addAttribute("service", service);
        model.addAttribute("message", "Reservation successful for " + guests + " guests on " + reservationDate);
        return "user/service-details"; // Return to the same page with confirmation
    }

    @PostMapping("/user/{serviceId}/payment")
    public String makePayment(@PathVariable int serviceId,
                              @RequestParam double amount,
                              Model model) {
        // Logic for payment handling
        Ser service = serviceService.getServiceById(serviceId);

        // Payment integration logic can be added here
        model.addAttribute("service", service);
        model.addAttribute("message", "Payment of $" + amount + " was successful!");
        return "user/service-details"; // Return to the same page with payment confirmation
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
        model.addAttribute("service", new Ser()); // Empty service object for form binding
        return "provider/service-create"; // Reusing the service-update.html template for both create and edit
    }

    /**
     * Handle the submission of the create form.
     * <a href="http://localhost:8080/services/new">Submit New Service</a>
     */
    @PostMapping("/new/{id}")
    public String createService(@ModelAttribute Ser service, @PathVariable int id) {
        User user = userService.getUserById(id);
        serviceService.createService(service, user);
        return "redirect:/services/user?userId=" + id;
    }

    /**
     * Display the update form for a specific service.
     * <a href="http://localhost:8080/services/update/{serviceId}">Update Service</a>
     */
    @GetMapping("/update/{serviceId}")
    public String showUpdateForm(@PathVariable int serviceId, Model model) {
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


    //ADMiN
    //Get all services
    @GetMapping("/all")
    public String getAllServicesForAdmin(Model model) {
        model.addAttribute("serviceList", serviceService.getAllServices());
        return "admin-management";
    }

    @PostMapping("/delete/{serviceId}")
    public String deleteService(@PathVariable int serviceId) {
        serviceService.deleteServiceForAdmin(serviceId);
        return "redirect:/users/all";
    }
    @PostMapping("/undelete/{serviceId}")
    public String undeleteService(@PathVariable int serviceId) {
        serviceService.undeleteServiceForAdmin(serviceId);
        return "redirect:/users/all";
    }



}
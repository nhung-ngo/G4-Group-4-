package com.csc340.mvc_demo.Booking;


import com.csc340.mvc_demo.service.Ser;
import com.csc340.mvc_demo.service.SerService;
import com.csc340.mvc_demo.user.User;
import com.csc340.mvc_demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private SerService serviceService;

    @Autowired
    private UserService userService;

    @GetMapping("/new/{serviceId}/user/{userId}")
    public String showReservationPage(@PathVariable int serviceId, Model model,@PathVariable int userId) {
        Ser service = serviceService.getServiceById(serviceId); // Fetch service details
        User user = userService.getUserById(userId); // Fetch logged-in user
        model.addAttribute("service", service);
        model.addAttribute("user", user);
        return "user/reservation";
    }
    @PostMapping("/confirm")
    public String confirmReservation(@RequestParam int serviceId, @RequestParam int userId) {
        Ser service = serviceService.getServiceById(serviceId); // Get service
        User user = userService.getUserById(userId);        // Get user
        int totalPayment = (int) service.getPrice();       // Get price from service

        Booking booking = new Booking(service, "pending", totalPayment, user);
        bookingService.createBooking(booking); // Save booking using service layer

        return "redirect:/services/home?userId=" + userId; // Redirect to services or a booking confirmation page
    }

    @GetMapping("/history")
    public String bookingHistory(Model model, @RequestParam("userId") int userId) {
        List<Booking> bookings = bookingService.getBookingsByUserId(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("bookings", bookings);
        return "user/history";
    }

    @GetMapping("/service/{serviceId}")
    public String viewBookings(@PathVariable int serviceId, Model model) {
        List<Booking> bookings = bookingService.getBookingsByService(serviceId);
        model.addAttribute("bookings", bookings);
        model.addAttribute("serviceId", serviceId);
        return "provider/bookings";
    }

    // Confirm a pending booking
    @PostMapping("provider/confirm/{bookingId}")
    public String confirmBooking(@PathVariable int bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        int serviceId = booking.getService().getServiceId();
        bookingService.confirmBooking(bookingId);
        return "redirect:/booking/service/" + serviceId;
    }
}

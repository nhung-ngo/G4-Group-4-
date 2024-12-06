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

    // GET all bookings
    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // GET a booking by ID
    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id);
    }

    // POST a new booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);

    }

    // PUT to update an existing booking
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking bookingdetails) {
        return bookingService.updateBooking(id, bookingdetails);
    }

    // DELETE a booking
    @DeleteMapping("/{id}")
    public List<Booking> deleteBooking(@PathVariable Integer id) {
         bookingService.deleteBooking(id);
         return bookingService.getAllBookings();
    }
}

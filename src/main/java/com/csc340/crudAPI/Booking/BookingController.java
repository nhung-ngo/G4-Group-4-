package com.csc340.crudAPI.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

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

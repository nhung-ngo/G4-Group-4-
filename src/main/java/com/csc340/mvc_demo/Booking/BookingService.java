package com.csc340.mvc_demo.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;



    public List<Booking> getBookingsByUserId(int userId) {
        return bookingRepository.findByUserUserId(userId);
    }
    public Booking getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(int bookingID) {
        bookingRepository.deleteById(bookingID);
    }

    // Get all bookings for a specific service
    public List<Booking> getBookingsByService(int serviceId) {
        return bookingRepository.findByServiceServiceId(serviceId);
    }

    // Update booking status to "confirmed"
    public void confirmBooking(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
            booking.setStatus("confirmed");
            bookingRepository.save(booking);

    }

}

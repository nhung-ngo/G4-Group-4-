package com.csc340.crudAPI.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;



    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int bookingId) {
        return bookingRepository.findById( bookingId);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(int bookingID, Booking bookingDetails) {
        return bookingRepository.findById(bookingID).map(booking -> {
            booking.setUser(bookingDetails.getUser());
            booking.setService(bookingDetails.getService()) ;
            booking.setTotalPayment(bookingDetails.getTotalPayment());
            booking.setStatus(bookingDetails.getStatus());
            return bookingRepository.save(booking);
        }) .orElseThrow(() -> new RuntimeException("Service not found with id " + bookingID));
    }

    public void deleteBooking(int bookingID) {
        bookingRepository.deleteById(bookingID);
    }

}

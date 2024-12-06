package com.csc340.mvc_demo.Booking;

import com.csc340.mvc_demo.service.Ser;
import com.csc340.mvc_demo.user.User;
import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user; // Reference to the parent review4
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Ser service; // Reference to the parent review
    private int totalPayment;
    private String status;


    public Ser getService() {
        return service;
    }

    public void setService(Ser service) {
        this.service = service;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Booking() {

    }

    public Booking(Ser service, String status, int totalPayment, User user) {
        this.service = service;
        this.status = status;
        this.totalPayment = totalPayment;
        this.user = user;
    }

    // Getters and Setters

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }




    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

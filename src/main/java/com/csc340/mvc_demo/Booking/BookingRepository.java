package com.csc340.mvc_demo.Booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value =  "SELECT COUNT(bookingid) FROM booking where service_id=?1 ", nativeQuery = true)
    int countTotalBookingForAService(int serviceid);

    @Query(value = "SELECT COUNT(bookingid) FROM booking", nativeQuery = true)
    int countTotalBooking();

    List<Booking> findByUserUserId(int userId);

    List<Booking> findByServiceServiceId(int serviceId);


}

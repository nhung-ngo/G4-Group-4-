package com.csc340.mvc_demo.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Ser, Integer> {
    @Query(value= "select * from service where user_id = ?1", nativeQuery = true)
    List<Ser> findByUserId(int userId);

    @Query(value = "SELECT COUNT(service_id) FROM service", nativeQuery = true)
    int countTotalServices();



}

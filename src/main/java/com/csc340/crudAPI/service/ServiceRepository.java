package com.csc340.crudAPI.service;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface ServiceRepository extends JpaRepository<Ser, Long> {

}

package com.csc340.crudAPI.Statistic;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String action;

    private LocalDateTime generatedAt;

    public Statistics() {
        this.generatedAt = LocalDateTime.now();
    }




}


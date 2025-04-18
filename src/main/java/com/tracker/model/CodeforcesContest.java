package com.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CodeforcesContest {

    @Id
    private Long id;
    private String name;
    private String startTime;
    private String duration;

    // Getters and Setters
}

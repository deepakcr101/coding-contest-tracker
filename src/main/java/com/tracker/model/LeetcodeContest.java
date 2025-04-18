package com.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LeetcodeContest {

    @Id
    private String titleSlug;
    private String title;
    private String startTime;
    private String duration;

    // Getters and Setters
}

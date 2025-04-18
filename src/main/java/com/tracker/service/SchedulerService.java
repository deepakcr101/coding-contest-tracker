package com.tracker.service;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    private final ContestService contestService;

    public SchedulerService(ContestService contestService) {
        this.contestService = contestService;
    }

    @Scheduled(fixedRate = 3600000) // every 1 hour
    public void refreshContests() {
        System.out.println("🔄 Auto-refreshing contest data at " + LocalDateTime.now());
        contestService.fetchAndSaveAllContests();
    }
}

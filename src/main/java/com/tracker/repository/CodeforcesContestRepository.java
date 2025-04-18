package com.tracker.repository;

import com.tracker.model.CodeforcesContest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeforcesContestRepository extends JpaRepository<CodeforcesContest, Long> {
}


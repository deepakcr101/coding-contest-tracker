package com.tracker.repository;

import com.tracker.model.LeetcodeContest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeetcodeContestRepository extends JpaRepository<LeetcodeContest, String> {
}

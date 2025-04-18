package com.tracker.service;

import com.tracker.model.CodeforcesContest;
import com.tracker.model.LeetcodeContest;
import com.tracker.repository.CodeforcesContestRepository;
import com.tracker.repository.LeetcodeContestRepository;
import com.tracker.util.CodeforcesAPIUtil;
import com.tracker.util.LeetcodeAPIUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final CodeforcesContestRepository codeforcesRepo;
    private final LeetcodeContestRepository leetcodeRepo;

    public ContestService(CodeforcesContestRepository codeforcesRepo, LeetcodeContestRepository leetcodeRepo) {
        this.codeforcesRepo = codeforcesRepo;
        this.leetcodeRepo = leetcodeRepo;
    }

    public void fetchAndSaveAllContests() {
        // Fetch contests
        List<CodeforcesContest> codeforcesContests = CodeforcesAPIUtil.fetchCodeforcesContests();
        List<LeetcodeContest> leetcodeContests = LeetcodeAPIUtil.fetchLeetcodeContests();

        // Save to DB
        codeforcesRepo.saveAll(codeforcesContests);
        leetcodeRepo.saveAll(leetcodeContests);

        System.out.println("✅ Contests updated and saved to database.");
    }

    public List<CodeforcesContest> getAllCodeforcesContests() {
        return codeforcesRepo.findAll();
    }

    public List<LeetcodeContest> getAllLeetcodeContests() {
        return leetcodeRepo.findAll();
    }
}

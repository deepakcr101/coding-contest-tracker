package com.tracker.controller;

import com.tracker.model.Contest;
import com.tracker.service.DBService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContestController {
    DBService dbService = new DBService();

    @GetMapping("/contests")
    public String showContests(Model model) {
        List<Contest> contests = dbService.getAllContests();
        model.addAttribute("contests", contests);
        return "contests";
    }
}

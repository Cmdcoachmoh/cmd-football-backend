package com.cmdfootball.controller;

import com.cmdfootball.model.RunningTest;
import com.cmdfootball.service.WeeklyRunningTestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/running")
public class WeeklyRunningTestController {

    private final WeeklyRunningTestService service = new WeeklyRunningTestService();

    @GetMapping("/weekly")
    public List<RunningTest> getWeeklyRunningTests() {
        return service.getWeeklyTests();
    }
}


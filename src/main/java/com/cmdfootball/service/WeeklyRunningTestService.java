package com.cmdfootball.service;

import com.cmdfootball.model.RunningTest;
import com.cmdfootball.data.WeeklyRunningTestData;
import java.util.List;

public class WeeklyRunningTestService {
    public List<RunningTest> getWeeklyTests() {
        return WeeklyRunningTestData.getTests();
    }
}


package com.cmdfootball.data;

import com.cmdfootball.model.RunningTest;
import java.util.List;

public class WeeklyRunningTestData {

    // VO₂ Max estimation formula
    private static double estimateVO2(double speed) {
        return 3.5 + (speed * 0.2); // VO₂ in ml/kg/min
    }

    public static List<RunningTest> getTests() {
        return List.of(
            // Week 3 — Ali
            new RunningTest("Ali", "Tuesday", 3, "Week3-Tuesday", 7, 700, 5, 140.0, estimateVO2(140.0)),
            new RunningTest("Ali", "Wednesday", 3, "Week3-Wednesday", 8, 800, 5, 160.0, estimateVO2(160.0)),
            new RunningTest("Ali", "Thursday", 3, "Week3-Thursday", 9, 900, 5, 180.0, estimateVO2(180.0)),

            // Week 3 — Zara
            new RunningTest("Zara", "Tuesday", 3, "Week3-Tuesday", 6, 600, 5, 120.0, estimateVO2(120.0)),
            new RunningTest("Zara", "Wednesday", 3, "Week3-Wednesday", 7, 700, 5, 140.0, estimateVO2(140.0)),
            new RunningTest("Zara", "Thursday", 3, "Week3-Thursday", 8, 800, 5, 160.0, estimateVO2(160.0)),

            // Week 3 — Leo
            new RunningTest("Leo", "Tuesday", 3, "Week3-Tuesday", 5, 500, 5, 100.0, estimateVO2(100.0)),
            new RunningTest("Leo", "Wednesday", 3, "Week3-Wednesday", 6, 600, 5, 120.0, estimateVO2(120.0)),
            new RunningTest("Leo", "Thursday", 3, "Week3-Thursday", 7, 700, 5, 140.0, estimateVO2(140.0))
        );
    }
}

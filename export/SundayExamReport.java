package com.cmdfootball.export;

import com.cmdfootball.model.Player;
import com.cmdfootball.model.DrillAttempt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SundayExamReport {

    /**
     * Generates a summary report for Sunday drill attempts.
     *
     * @param attempts list of drill attempts performed on Sunday
     * @return map of player ID to performance summary
     */
    public static Map<Long, PlayerPerformance> generateReport(List<DrillAttempt> attempts) {
        return attempts.stream()
                .filter(attempt -> isSunday(attempt.getTimestamp().toLocalDate()))
                .collect(Collectors.groupingBy(
                        DrillAttempt::getPlayerId,
                        Collectors.collectingAndThen(Collectors.toList(), SundayExamReport::summarizePerformance)
                ));
    }

    private static boolean isSunday(LocalDate date) {
        return date.getDayOfWeek().getValue() == 7;
    }

    private static PlayerPerformance summarizePerformance(List<DrillAttempt> attempts) {
        int totalScore = attempts.stream().mapToInt(DrillAttempt::getScore).sum();
        long successfulCount = attempts.stream().filter(DrillAttempt::isSuccessful).count();
        int totalAttempts = attempts.size();
        double averageScore = totalAttempts > 0 ? (double) totalScore / totalAttempts : 0.0;

        return new PlayerPerformance(averageScore, successfulCount, totalAttempts);
    }

    public static class PlayerPerformance {
        private final double averageScore;
        private final long successfulAttempts;
        private final int totalAttempts;

        public PlayerPerformance(double averageScore, long successfulAttempts, int totalAttempts) {
            this.averageScore = averageScore;
            this.successfulAttempts = successfulAttempts;
            this.totalAttempts = totalAttempts;
        }

        public double getAverageScore() { return averageScore; }
        public long getSuccessfulAttempts() { return successfulAttempts; }
        public int getTotalAttempts() { return totalAttempts; }

        @Override
        public String toString() {
            return String.format("Avg Score: %.2f | Success: %d/%d", averageScore, successfulAttempts, totalAttempts);
        }
    }
}
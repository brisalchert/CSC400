//----------------------------------------------------------------------------------------------------------------------
//  LeaderboardSorting.java
//
//  Program for exemplifying merge sort on a leaderboard.
//----------------------------------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Comparator;

public class LeaderboardSorting {
    public static void main(String[] args) {
        // Initialize an ArrayList of scores
        ArrayList<Score> scores = new ArrayList<>();

        // Add scores to the list
        scores.add(new Score(25.6, "2024-08-28"));
        scores.add(new Score(25.6, "2023-10-27"));
        scores.add(new Score(38.5, "2023-11-14"));
        scores.add(new Score(28.3, "2024-05-17"));
        scores.add(new Score(68.2, "2024-09-05"));
        scores.add(new Score(38.5, "2023-11-13"));

        // Initialize comparators for the sorting algorithm
        Comparator<Score> dateComparator = Score.getDateComparator();
        Comparator<Score> scoreComparator = Score.getScoreComparator();

        // Print the scoreboard before sorting
        System.out.println("SCOREBOARD:");
        System.out.println("--------------------------");

        for (Score score : scores) {
            System.out.println(score);
        }

        MergeSort sort = new MergeSort();

        // First, sort by date
        sort.mergeSort(scores, dateComparator);

        // Second, sort by score
        sort.mergeSort(scores, scoreComparator);

        // Print the scoreboard
        System.out.println("\nAfter sorting:\n");

        System.out.println("SCOREBOARD:");
        System.out.println("--------------------------");

        for (Score score : scores) {
            System.out.println(score);
        }
    }

    private static class Score {
        private double score;
        private String date;

        /**
         * Constructor: Initialize a Score object with a score and a date achieved
         * @param score the score
         * @param date the date the score was achieved
         */
        public Score(double score, String date) {
            this.score = score;
            this.date = date;
        }

        public static Comparator<Score> getDateComparator() {
            class DateComparator implements Comparator<Score> {
                @Override
                public int compare(Score score1, Score score2) {
                    // Compares the dates and returns a value corresponding to whether
                    // the first date is larger
                    return Integer.compare(score1.date.compareTo(score2.date), 0);
                }
            }

            return new DateComparator();
        }

        public static Comparator<Score> getScoreComparator() {
            class ScoreComparator implements Comparator<Score> {
                @Override
                public int compare(Score score1, Score score2) {
                    // Compares the scores and returns a value corresponding to whether
                    // the first score is larger (negated because larger scores should be
                    // sorted in descending order)
                    return Double.compare(score1.score, score2.score) * -1;
                }
            }

            return new ScoreComparator();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(score);
            sb.append(", Achieved: ");
            sb.append(date);

            return sb.toString();
        }
    }
}

package Assingment2;

import java.util.Scanner;

public class AttendanceReport {

    // 1. Count number of present days
    static int countPresent(int[] att) {
        int count = 0;
        for (int i = 0; i < att.length; i++) {
            if (att[i] == 1) {
                count++;
            }
        }

        return count;
    }
    // 2. Calculate attendance percentage
    static double percentage(int present, int total) {

        if (total == 0){
            return 0.0;
        }

        return ((double) present / total) * 100;
    }
    // 3. Find longest continuous streak
    static void longestStreak(int[] att, int value) {
        int current = 0;
        int best = 0;
        int bestEnd = -1;
        for (int i = 0; i < att.length; i++) {
            if (att[i] == value) {
                current++;
                if (current > best) {
                    best = current;
                    bestEnd = i;
                }
            } else {
                current = 0;
            }
        }
        // If no streak was found
        if (best == 0) {

            System.out.println("Longest streak of " + value + " : 0 days");

        } else {

            int startDay = bestEnd - best + 2;
            int endDay = bestEnd + 1;

            if (value == 1) {
                System.out.println("Longest presence : "
                        + best + " days (day "
                        + startDay + " to day "
                        + endDay + ")");
            } else {
                System.out.println("Longest absence : "
                        + best + " days (day "
                        + startDay + " to day "
                        + endDay + ")");
            }
        }
    }

    // 4. Find number of additional days needed to reach 75%
    static int daysNeeded(int present, int total) {

        int days = 0;

        while (percentage(present, total) < 75) {

            present++;//11-> 12->13
            total++;//15->16->17
            days++;//0->1->2
        }

        return days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        int[] att = new int[days];

        System.out.println("Enter attendance (1 = Present, 0 = Absent):");

        for (int i = 0; i < att.length; i++) {
            att[i] = sc.nextInt();
        }

        // Count present days
        int present = countPresent(att);//11

        // Total days
        int total = att.length;

        // Calculate percentage
        double attendancePercentage = percentage(present, total);

        // Print report
        System.out.println();
        System.out.println("----- Attendance Report -----");

        System.out.println("Days present : "
                + present + " of " + total);

        System.out.println("Attendance : "
                + String.format("%.2f", attendancePercentage) + " %");

        // Eligibility
        if (attendancePercentage >= 75) {
            System.out.println("Eligible : YES");
        } else {
            System.out.println("Eligible : NO");

            int needed = daysNeeded(present, total);

            System.out.println("Days needed for 75% : "
                    + needed);
        }

        // Longest presence
        longestStreak(att, 1);

        // Longest absence
        longestStreak(att, 0);

        sc.close();
    }
}
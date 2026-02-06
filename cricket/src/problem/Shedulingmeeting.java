package problem;

class Shedulingmeeting {

    static class Meeting {
        int start, end, people;

        Meeting(int start, int end, int people) {
            this.start = start;
            this.end = end;
            this.people = people;
        }
    }

    public static void solve(int N, int[] people, int[] starting, int[] ending) {
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            meetings[i] = new Meeting(starting[i], ending[i], people[i]);
        }

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = meetings[i].people;

            for (int j = 0; j < i; j++) {
                // Check if meeting j ends strictly before meeting i starts
                if (meetings[j].end < meetings[i].start) {
                    dp[i] = Math.max(dp[i], meetings[i].people + dp[j]);
                }
            }
        }

        // Find max value in dp[]
        int maxPeopleCanMeet = 0;
        for (int val : dp) maxPeopleCanMeet = Math.max(maxPeopleCanMeet, val);

        int totalPeople = 0;
        for (int val : people) totalPeople += val;

        System.out.println(totalPeople - maxPeopleCanMeet);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] people = {3, 5, 6, 10, 4};
        int[] starting = {1, 2, 3, 6, 5};
        int[] ending = {1, 2, 5, 7, 7};

        solve(N, people, starting, ending); // Output: 10
    }
}
/*package problem;

import java.util.*;

class Shedulingmeeting {

    static class Meeting {
        int start, end, people;

        Meeting(int start, int end, int people) {
            this.start = start;
            this.end = end;
            this.people = people;
        }
    }

    public static void solve(int N, int[] people, int[] starting, int[] ending) {
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            meetings.add(new Meeting(starting[i], ending[i], people[i]));
        }

        // Sort meetings by end time (TreeMap-like order)
        meetings.sort(Comparator.comparingInt(m -> m.end));

        int[] dp = new int[N];
        dp[0] = meetings.get(0).people;

        for (int i = 1; i < N; i++) {
            int include = meetings.get(i).people;

            // Binary search for the last meeting that ends before current starts
            int lo = 0, hi = i - 1, lastNonOverlap = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (meetings.get(mid).end < meetings.get(i).start) {
                    lastNonOverlap = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (lastNonOverlap != -1) {
                include += dp[lastNonOverlap];
            }

            dp[i] = Math.max(dp[i - 1], include);
        }

        int total = 0;
        for (int val : people) total += val;

        System.out.println(total - dp[N - 1]);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] people = {3, 5, 6, 10, 4};
        int[] starting = {1, 2, 3, 6, 5};
        int[] ending = {1, 2, 5, 7, 7};

        solve(N, people, starting, ending); // Output: 10
    }
}
*/
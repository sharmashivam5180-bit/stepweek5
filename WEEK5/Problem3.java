package WEEK5;

import java.util.Arrays;

public class Problem3 {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int s : scores) {
            // Using >= (not >) lets a tie for the top value correctly
            // shift the previous top values down into 2nd/3rd place.
            if (s >= first) {
                third = second;
                second = first;
                first = s;
            } else if (s >= second) {
                third = second;
                second = s;
            } else if (s >= third) {
                third = s;
            }
        }
        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(scores)));
        // Expected: [90, 90, 82]
    }
}

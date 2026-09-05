package WEEK5;

public class Problem4 {

    // Private helper: computes the average of a single row.
    // Handles jagged rows automatically since it only depends on row.length.
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

            result.append("Row ").append(i).append(": ").append(zone);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
        // Expected: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone

        // Jagged grid test
        int[][] jaggedGrid = {
            {40, 50},
            {85, 90, 95, 100},
            {30}
        };
        System.out.println(classifyRows(jaggedGrid, 60));
    }
}
package WEEK5;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    // Composite score = cgpa weighted x10 + codingScore weighted x0.5
    public double getCompositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    // Overload 1: CGPA-only quick filter
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Overload 2: combined filter for borderline CGPA candidates
    static boolean isEligible(double cgpa, int codingScore) {
        return (cgpa >= 6.5 && cgpa < 7.0) && (codingScore >= 60);
    }

    // Descending order by composite score, so Arrays.sort() ranks highest first
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class Problem5 {

    static String shortlistAndRank(Candidate[] candidates) {
        // Step 1: Determine who is eligible
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            boolean eligible = Candidate.isEligible(c.getCgpa())
                    || Candidate.isEligible(c.getCgpa(), c.getCodingScore());
            if (eligible) {
                temp[count++] = c;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(temp, count);

        // Step 2: Rank using Candidate's own compareTo() via Arrays.sort
        Arrays.sort(shortlisted);

        // Step 3: Build the output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (")
                  .append(shortlisted[i].getCompositeScore())
                  .append(")");
            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
        // Expected: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}
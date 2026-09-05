package Week1;

public class BMI {
    public static String status(double bmi) {
        if (bmi < 18.5) return "Under";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Over";
        return "Obese";
    }

    public static void report(double[] h, double[] w) {
        System.out.println("ID | H(m) | W(kg) | BMI | Stat");
        for (int i = 0; i < h.length; i++) {
            double b = w[i] / (h[i] * h[i]);
            System.out.printf("%d  | %.2f | %.1f  | %.1f | %s%n", (i + 1), h[i], w[i], b, status(b));
        }
    }

    public static void main(String[] args) {
        double[] h = {1.75, 1.60, 1.80};
        double[] w = {70.0, 90.0, 75.0};
        report(h, w);
    }
}

package Week1;

public class Rev {
    public static String reverse(String name) {
        return new StringBuilder(name).reverse().toString();
    }

    public static void main(String[] args) {
        String n = "Sunil";
        System.out.println("Orig: " + n + " | Rev: " + reverse(n));
    }
}

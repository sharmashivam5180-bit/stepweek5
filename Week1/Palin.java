package Week1;

public class Palin {
    public static boolean checkIter(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static boolean checkRec(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return checkRec(s.substring(1, s.length() - 1));
    }

    public static boolean checkArr(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void print(String s) {
        System.out.printf("\"%s\" | Iter: %b | Rec: %b | Arr: %b%n", 
                          s, checkIter(s), checkRec(s), checkArr(s));
    }

    public static void main(String[] args) {
        print("madam");
        print("hello");
    }
}

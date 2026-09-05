package Week1;

import java.util.LinkedHashMap;

public class Unique {
    public static char find(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (var e : map.entrySet()) if (e.getValue() == 1) return e.getKey();
        return '\0';
    }

    public static void main(String[] args) {
        String[] arr = {"swiss", "aabbcc"};
        for (String s : arr) {
            char res = find(s);
            System.out.println(s + " -> " + (res == '\0' ? "None" : res));
        }
    }
}

package Week1;

import java.util.Random;

public class RPS {
    public static String play(String p, String c) {
        if (p.equals(c)) return "Draw";
        if ((p.equals("Rock") && c.equals("Scissors")) ||
            (p.equals("Paper") && c.equals("Rock")) ||
            (p.equals("Scissors") && c.equals("Paper"))) return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] opts = {"Rock", "Paper", "Scissors"};
        String[] pMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random r = new Random();
        int w = 0, l = 0, d = 0, n = 5;

        for (int i = 0; i < n; i++) {
            String cMove = opts[r.nextInt(3)];
            String res = play(pMoves[i], cMove);
            System.out.printf("R%d | P: %s, C: %s | %s%n", (i + 1), pMoves[i], cMove, res);
            if (res.equals("Player Wins")) w++;
            else if (res.equals("Computer Wins")) l++;
            else d++;
        }
        System.out.printf("Summary | W: %d | L: %d | D: %d | Win %%: %.1f%%%n", w, l, d, (w * 100.0 / n));
    }
}

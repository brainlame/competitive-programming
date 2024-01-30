import java.util.*;
import java.io.*;

public class Problem {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tests = 0; tests < t; tests++) {
            int n = sc.nextInt();
            int[] hay = new int[n];
            for (int i = 0; i < n; i++) {
                hay[i] = sc.nextInt();
            }
            TreeSet<Integer> solutions = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if (i >= 2) if (hay[i - 2] == hay[i]) solutions.add(hay[i]);
                if (i <= n - 3) if (hay[i + 2] == hay[i]) solutions.add(hay[i]);
                if (i >= 1) if (hay[i - 1] == hay[i]) solutions.add(hay[i]);
                if (i <= n - 2) if (hay[i + 1] == hay[i]) solutions.add(hay[i]);
            }
            if (solutions.isEmpty()) System.out.print(-1);
            for (int s : solutions) {
                if (s == solutions.first())
                    System.out.print(s);
                else 
                    System.out.print(" " + s);
            }
            System.out.println();
        }
    }

}
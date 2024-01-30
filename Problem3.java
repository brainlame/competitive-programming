import java.util.*;
import java.io.*;

public class Problem3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long[] ideal = new long[n];
        for (int i = 0; i < n; i++) {
            ideal[i] = 0;
        }
        int sprays = 0;
        for (int leftmost = 0; leftmost < n; leftmost++) {
            long curSprays = Math.abs(a[leftmost] - ideal[leftmost]);
            sprays += curSprays;
            // decide if adding or removing bacteria
            boolean isIncrement;
            if (a[leftmost] - ideal[leftmost] < 0) isIncrement = true;
            else isIncrement = false;
            // visualize what happens after spray
            ideal[leftmost] = a[leftmost];
            for (int i = leftmost + 1; i < n; i++) {
                if (isIncrement)
                    ideal[i] -= curSprays * (i - leftmost + 1);
                else
                    ideal[i] += curSprays * (i - leftmost + 1);
                }
            // System.out.println("index: " + leftmost + " " + Arrays.toString(ideal));
        }
        System.out.println(sprays);
    }

}
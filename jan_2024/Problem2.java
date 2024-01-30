import java.util.*;
import java.io.*;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int loc = sc.nextInt();
        int[] type = new int[n + 1];
        int[] value = new int[n + 1];
        int initialTargets = 0;
        for (int i = 1; i <= n; i++) {
            type[i] = sc.nextInt();
            value[i] = sc.nextInt();
            initialTargets += type[i] == 1 ? 1 : 0;
        }
        int power = 1;
        boolean goingRight = true;
        int targets = 0;
        int iter = 0;
        while (loc >= 1 && loc <= n) {
            iter++;
            if (iter > 500000) break;
            // break current target
            if (type[loc] == 1 && value[loc] <= power) {
                type[loc] = 2;
                targets++;
                if (targets == initialTargets) break;
            } 
            // landed on a jump pad
            else if (type[loc] == 0) {
                goingRight = !goingRight;
                power += value[loc];
            }
            // advance
            if (goingRight) loc += power;
            else loc -= power;
        }
        System.out.println(targets);
    }
}
package lab6.EithinthTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        int[] count = new int[n + 1];
        count[1] = k - 1;
        count[2] = (k - 1) * k;
        for (int i = 3; i <= n; i++) {
            count[i] = (count[i - 1] + count[i - 2]) * (k - 1);
        }
        System.out.println(count[n]);
    }
}

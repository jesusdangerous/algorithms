package lab4.FirstTask;

import java.util.Scanner;

public class FirstTask {
    public static int getMaxLength(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt();

        int[] lens = new int[n];
        long totalLength = 0;

        for (int i = 0; i < n; i++) {
            lens[i] = s.nextInt();
            totalLength += lens[i];
        }

        if (totalLength < k) {
            return 0;
        }

        int left = 0;
        int right = 10 * 1000 * 1000 + 1;

        while (left + 1 < right) {
           int mid = (left + right) / 2;
            int count = 0;
            for (int len : lens) {
                count += len / mid;
            }

            if (count >= k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

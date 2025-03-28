package lab4.FifthTask;


import java.util.*;
public class FifthTask {
    public static int findMinTime(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        n--;

        if (n == 0) {
            return x;
        }

        int left = 0;
        int right = n * x;

        while (left < right) {
            int mid = (left + right) / 2;
            int copiesMade = (mid / x) + (mid / y);

            if (copiesMade >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left + x;
    }
//    public static int findMinTime(String[] a) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt(), x = s.nextInt(), y = s.nextInt();
//        if (x > y) { int t = x; x = y; y = t; }
//        n--;
//        int k = n * y / (x + y);
//        return x + Math.min(Math.max(k * x, (n - k) * y), Math.max(++k * x, (n - k) * y));
//    }
}


package lab4.FifthTask;


import java.util.*;
public class FifthTask {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), x = s.nextInt(), y = s.nextInt();
        if (x > y) { int t = x; x = y; y = t; }
        n--;
        int k = n * y / (x + y);
        System.out.print(x + Math.min(Math.max(k * x, (n - k) * y), Math.max(++k * x, (n - k) * y)));
    }
}


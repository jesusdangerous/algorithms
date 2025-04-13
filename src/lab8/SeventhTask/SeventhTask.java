package lab8.SeventhTask;

import java.io.*;
import java.util.Scanner;

public class SeventhTask {
    public static int findCyclicLineShift(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();
        String T = scanner.nextLine();

        if (S.length() != N || T.length() != N) {
            return -1;
        }

        if (S.equals(T)) {
            return 0;
        }

        String combined = S + S;
        int index = kmpSearch(T, combined);

        if (index == -1) {
            return -1;
        } else {
            return (N - index) % N;
        }
    }

    private static int[] computePrefixFunction(String pattern) {
        int[] prefix = new int[pattern.length()];
        int k = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = prefix[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(i)) {
                k++;
            }
            prefix[i] = k;
        }
        return prefix;
    }

    private static int kmpSearch(String pattern, String text) {
        int[] prefix = computePrefixFunction(pattern);
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            while (k > 0 && pattern.charAt(k) != text.charAt(i)) {
                k = prefix[k - 1];
            }
            if (pattern.charAt(k) == text.charAt(i)) {
                k++;
            }
            if (k == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }
}

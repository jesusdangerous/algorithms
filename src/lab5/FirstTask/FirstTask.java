package lab5.FirstTask;

import java.util.Scanner;


public class FirstTask {
    public static int getWeightSubstring(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int maxWeight = 0;
        int n = input.length();

        for (int len = 1; len <= n; len++) {
            HashMap countMap = new HashMap();

            for (int i = 0; i + len <= n; i++) {
                String sub = input.substring(i, i + len);
                countMap.increment(sub);
            }

            int maxFreq = countMap.maxValue();
            maxWeight = Math.max(maxWeight, maxFreq * len);
        }

        return maxWeight;
    }
}


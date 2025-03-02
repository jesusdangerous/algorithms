package lab1.SeventhTask;

public class SeventhTask {
    public static int minDifference(String count, String numbers) {
        int n = Integer.parseInt(count);
        int[] weights = new int[n];
        int totalSum = 0;
        int j = 0;
        for (String number : numbers.split(" ")) {
            weights[j] = Integer.parseInt(number);
            totalSum += weights[j];
            j++;
        }

        int minDifference = Integer.MAX_VALUE;
        int subsets = 1 << n;

        for (int mask = 0; mask < subsets; mask++) {
            int sumFirstHeap = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sumFirstHeap += weights[i];
                }
            }
            int sumSecondHeap = totalSum - sumFirstHeap;
            minDifference = Math.min(minDifference, abs(sumFirstHeap - sumSecondHeap));
        }

        return minDifference;
    }

    private static int abs(int a) {
        return (a <= 0) ? -a : a;
    }
}
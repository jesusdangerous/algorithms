package lab6.FirstTask;

public class FirstTask {
    static class MaxSumRange {
        public int start;
        public int end;
        public int maxSum;

        public MaxSumRange(int start, int end, int maxSum) {
            this.start = start;
            this.end = end;
            this.maxSum = maxSum;
        }
    }

    public MaxSumRange getMaxSumRange(int[] arr) {
        int currSum = 0;
        int startIndex = 0;
        MaxSumRange maxSumRange = null;

        for (int endIndex = 0; startIndex < arr.length; endIndex++) {
            currSum += arr[endIndex];

            if (maxSumRange == null || currSum > maxSumRange.maxSum) {
                maxSumRange = new MaxSumRange(startIndex, endIndex, currSum);
            }

            if (currSum < 0) {
                currSum = 0;
                startIndex = endIndex + 1;
            }
        }
        return maxSumRange;
    }
}

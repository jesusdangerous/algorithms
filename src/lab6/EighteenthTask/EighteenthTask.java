package lab6.EighteenthTask;

public class EighteenthTask {
    public static int getNumber(int n, int k) {

        int[] count = new int[n + 1];
        count[1] = k - 1;
        count[2] = (k - 1) * k;
        for (int i = 3; i <= n; i++) {
            count[i] = (count[i - 1] + count[i - 2]) * (k - 1);
        }

        return count[n];
    }
}

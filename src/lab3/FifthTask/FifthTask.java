package lab3.FifthTask;

public class FifthTask {
    public static boolean isHeap(int[] array, int n) {
        for (int i = 1; i <= n; i++) {
            int left = 2 * i;
            int right = 2 * i + 1;

            if (left <= n && array[i] > array[left]) {
                return false;
            }
            if (right <= n && array[i] > array[right]) {
                return false;
            }
        }
        return true;
    }
}

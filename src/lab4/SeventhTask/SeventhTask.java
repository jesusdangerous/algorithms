package lab4.SeventhTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeventhTask {

    static class FenwickTree {
        private int size;
        private long[] list;
        private long[] fenwickList;

        public FenwickTree(int size) {
            this.size = size;
            this.list = new long[size];
            this.fenwickList = new long[size];
        }

        private int f1(int a) {
            return a & (a + 1);
        }

        private int f2(int a) {
            return a | (a + 1);
        }

        public void set(int index, long value) {
            long delta = value - list[index];
            list[index] = value;
            update(index, delta);
        }

        private void update(int index, long delta) {
            while (index < size) {
                fenwickList[index] += delta;
                index = f2(index);
            }
        }

        public long sum(int index) {
            long sum = 0;
            while (index >= 0) {
                sum += fenwickList[index];
                index = f1(index) - 1;
            }
            return sum;
        }

        public long rangeSum(int left, int right) {
            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }
            return sum(right) - sum(left - 1);
        }
    }

    public static List<Integer> processQueries(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        FenwickTree tree = new FenwickTree(n);

        for (int i = 0; i < n; i++) {
            long value = scanner.nextLong();
            tree.set(i, value);
        }

        for (int i = 0; i < m; i++) {
            int code = scanner.nextInt();
            if (code == 1) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                long sum = tree.rangeSum(l, r);
                results.add((int) sum);
            } else if (code == 2) {
                int index = scanner.nextInt();
                long value = scanner.nextLong();
                tree.set(index, value);
            }
        }

        return results;
    }
}
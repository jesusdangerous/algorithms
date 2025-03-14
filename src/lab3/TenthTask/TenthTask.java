package lab3.TenthTask;


import lab3.FourthTask.Stack;
import lab3.FourthTask.StackException;

import java.util.Scanner;

public class TenthTask {
    static class Segment {
        int left, right, index;

        Segment(int left, int right, int index) {
            this.left = left;
            this.right = right;
            this.index = index;
        }
    }

    public static void solve(String[] args) throws StackException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Segment[] segments = new Segment[n + 1];
        for (int i = 1; i <= n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            segments[i] = new Segment(l, r, i);
        }

        int m = scanner.nextInt();
        Stack<Segment> stack = new Stack<>();

        int pivot = 1;
        while (m-- > 0) {
            int point = scanner.nextInt();

            while (pivot <= n && segments[pivot].left <= point) {
                stack.push(segments[pivot]);
                pivot++;
            }

            while (!stack.isEmpty() && stack.peek().right < point) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.println("-1");
            } else {
                Segment topSegment = stack.peek();
                System.out.println(topSegment.index);
            }
        }
    }
}


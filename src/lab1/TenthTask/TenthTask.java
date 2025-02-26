package lab1.TenthTask;

import java.util.Scanner;

public class TenthTask {
    public static void findTeam(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bitCount = new int[1 << 12];
        for (int code = 0; code < 1 << 12; code++) {
            int t = code;
            int count = 0;
            while (t > 0) {
                count += t & 1;
                t >>= 1;
            }
            bitCount[code] = count;
        }

        int n = scanner.nextInt();
        int size1 = scanner.nextInt();
        int nFriends = scanner.nextInt();

        int[] friends = new int[24];

        for (int i = 0; i < nFriends; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            friends[Math.min(a, b)] |= 1 << Math.max(a, b);
        }

        int codeCount;
        if (size1 == n - size1) {
            codeCount = 1 << (n - 1);
        } else {
            codeCount = 1 << n;
        }

        int bestCode = -1;
        int bestSum = -1;

        for (int code = (1 << size1) - 1; code < codeCount; code = nextBitPermutation(code)) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int friendsCode = (~(code << (31 - i) >> 31) ^ code) & friends[i];
                sum += bitCount[friendsCode >> 12] + bitCount[friendsCode & ((1 << 12) - 1)];
            }
            if (sum > bestSum) {
                bestCode = code;
                bestSum = sum;
            }
        }

        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (((bestCode >> i) & 1) != 0) {
                if (first) {
                    first = false;
                } else {
                    System.out.print(" ");
                }
                System.out.print(i + 1);
            }
        }

        scanner.close();
    }

    private static int nextBitPermutation(int n) {
        int tail1 = n & ~(n - 1);
        int resultHead = n + tail1;
        int oldOnes = n & ~resultHead;
        int newOnes = oldOnes / tail1 / 2;
        return resultHead + newOnes;
    }
}

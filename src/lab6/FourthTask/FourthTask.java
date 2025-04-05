package lab6.FourthTask;

import java.util.Arrays;
import java.util.Scanner;

public class FourthTask {
    static final int LIMIT = 20_000_000;

    public static boolean[] sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static int findK(int M, int N) {
        boolean[] isPrime = sieve(LIMIT);
        int[] primeCount = new int[LIMIT + 1];

        for (int i = 1; i <= LIMIT; i++) {
            primeCount[i] = primeCount[i - 1] + (isPrime[i] ? 1 : 0);
        }

        for (int K = 2; K <= LIMIT - N + 1; K++) {
            if (primeCount[K + N - 1] - primeCount[K - 1] == M) {
                return K;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.close();

        System.out.println(findK(M, N));
    }
}

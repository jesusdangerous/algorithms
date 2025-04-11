package lab6.FourthTask;


public class FourthTask {
    static final int LIMIT = 20_000_000;

    static class BitSet {
        private final int[] data;

        public BitSet(int size) {
            data = new int[(size >> 5) + 1];
        }

        public void set(int index) {
            data[index >> 5] |= (1 << (index & 31));
        }

        public boolean get(int index) {
            return (data[index >> 5] & (1 << (index & 31))) != 0;
        }

        public void clear(int index) {
            data[index >> 5] &= ~(1 << (index & 31));
        }
    }

    private static BitSet sieve(int limit) {
        BitSet isPrime = new BitSet(limit + 1);
        for (int i = 2; i <= limit; i++) isPrime.set(i);

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime.get(i)) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime.clear(j);
                }
            }
        }
        return isPrime;
    }

    public static int findK(int M, int N) {
        BitSet isPrime = sieve(LIMIT);
        int count = 0;

        for (int i = 2; i < 2 + N; i++) {
            if (isPrime.get(i)) count++;
        }

        if (count == M) return 2;

        for (int K = 3; K <= LIMIT - N + 1; K++) {
            if (isPrime.get(K - 1)) count--;
            if (isPrime.get(K + N - 1)) count++;

            if (count == M) return K;
        }

        return -1;
    }
}

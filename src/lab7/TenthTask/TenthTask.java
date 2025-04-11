package lab7.TenthTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TenthTask {
    static final int INF = Integer.MAX_VALUE;

    static class Set {
        private boolean[] present;

        public Set(int capacity) {
            present = new boolean[capacity];
        }

        public void add(int x) {
            present[x] = true;
        }

        public boolean contains(int x) {
            return present[x];
        }
    }

    static class PriorityQueue {
        private int[][] heap;
        private int size;
        private Comparator<int[]> comparator;
        public PriorityQueue(int capacity, Comparator<int[]> cmp) {
            heap = new int[capacity][];
            size = 0;
            comparator = cmp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void add(int[] element) {
            if (size == heap.length) {
                heap = Arrays.copyOf(heap, heap.length * 2);
            }
            heap[size] = element;
            siftUp(size);
            size++;
        }

        public int[] poll() {
            if (size == 0) {
                throw new NoSuchElementException("PriorityQueue is empty");
            }
            int[] min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            siftDown(0);
            return min;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (comparator.compare(heap[index], heap[parent]) < 0) {
                    swap(index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        private void siftDown(int index) {
            while (true) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;
                if (left < size && comparator.compare(heap[left], heap[smallest]) < 0) {
                    smallest = left;
                }
                if (right < size && comparator.compare(heap[right], heap[smallest]) < 0) {
                    smallest = right;
                }
                if (smallest != index) {
                    swap(index, smallest);
                    index = smallest;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int[] temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public static int getMinCost(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Set stations = new Set(n);
        for (int i = 0; i < k; i++) {
            stations.add(sc.nextInt() - 1);
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[n];
        int[] minEdge = new int[n];
        Arrays.fill(minEdge, INF);
        PriorityQueue pq = new PriorityQueue(n, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < n; i++) {
            if (stations.contains(i)) {
                minEdge[i] = 0;
                pq.add(new int[]{i, 0});
            }
        }

        int totalCost = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0];
            int costToConnect = current[1];

            if (visited[city])
                continue;
            visited[city] = true;
            totalCost += costToConnect;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && cost[city][i] < minEdge[i]) {
                    minEdge[i] = cost[city][i];
                    pq.add(new int[]{i, cost[city][i]});
                }
            }
        }

        return totalCost;
    }
}

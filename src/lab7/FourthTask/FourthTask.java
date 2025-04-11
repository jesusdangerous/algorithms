package lab7.FourthTask;

import java.util.Arrays;
import java.util.Scanner;

public class FourthTask {

    static class Point {
        int x, y, energy;

        public Point(int x, int y, int energy) {
            this.x = x;
            this.y = y;
            this.energy = energy;
        }
    }

    static class PriorityQueue {
        private Point[] heap;
        private int size;

        public PriorityQueue(int capacity) {
            heap = new Point[capacity];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void add(Point p) {
            if (size == heap.length) {
                heap = Arrays.copyOf(heap, heap.length * 2);
            }
            heap[size] = p;
            siftUp(size);
            size++;
        }

        public Point poll() {
            if (size == 0) return null;
            Point min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            siftDown(0);
            return min;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap[index].energy < heap[parent].energy) {
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

                if (left < size && heap[left].energy < heap[smallest].energy) {
                    smallest = left;
                }
                if (right < size && heap[right].energy < heap[smallest].energy) {
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
            Point temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static int minEnergy(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] heights = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[i][j] = sc.nextInt();
            }
        }

        int[][] energy = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(energy[i], Integer.MAX_VALUE);
        }

        PriorityQueue pq = new PriorityQueue(n * m / 2);
        energy[0][0] = 0;
        pq.add(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            int x = current.x, y = current.y, currEnergy = current.energy;

            if (x == n - 1 && y == m - 1) {
                return currEnergy;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int energyCost = Math.max(0, heights[nx][ny] - heights[x][y]);
                    int newEnergy = currEnergy + energyCost;

                    if (newEnergy < energy[nx][ny]) {
                        energy[nx][ny] = newEnergy;
                        pq.add(new Point(nx, ny, newEnergy));
                    }
                }
            }
        }

        return -1;
    }
}
package lab7.FifthTask;

import java.util.*;

public class FifthTask {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Stack {
        private int[][] data;
        private int size;

        public Stack(int capacity) {
            data = new int[capacity][];
            size = 0;
        }

        public void push(int[] item) {
            if (size == data.length) {
                data = Arrays.copyOf(data, data.length * 2);
            }
            data[size++] = item;
        }

        public int[] pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            int[] item = data[size - 1];
            data[size - 1] = null;
            size--;
            return item;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void dfs(int x, int y, int N, int M, char[][] grid, boolean[][] visited) {
        Stack stack = new Stack(100);
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int cx = cell[0], cy = cell[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && grid[nx][ny] == '+') {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }

    public static int countCarpets(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '+' && !visited[i][j]) {
                    dfs(i, j, N, M, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }
}
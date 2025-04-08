package lab7.FIfthTask;

import java.util.*;

public class FifthTask {

    // Направления для поиска соседей (вверх, вниз, влево, вправо)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y, int N, int M, char[][] grid, boolean[][] visited) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int cx = cell[0], cy = cell[1];

            // Проходим по соседям
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && grid[nx][ny] == '+') {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }

    public static int countCarpets(int N, int M, char[][] grid) {
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        // Проходим по всем клеткам
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // Если клетка закрашена и еще не посещена, то это новый коврик
                if (grid[i][j] == '+' && !visited[i][j]) {
                    dfs(i, j, N, M, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // Переход на новую строку

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        System.out.println(countCarpets(N, M, grid));
    }
}


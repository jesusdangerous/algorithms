package lab7.FourthTask;

import java.util.*;

public class FourthTask {

    static class Point {
        int x, y, energy;

        public Point(int x, int y, int energy) {
            this.x = x;
            this.y = y;
            this.energy = energy;
        }
    }

    static final int[] dx = {-1, 1, 0, 0}; // Дельты для движения по строкам
    static final int[] dy = {0, 0, -1, 1}; // Дельты для движения по столбцам

    public static int minEnergy(int n, int m, int[][] heights) {
        int[][] energy = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(energy[i], Integer.MAX_VALUE); // Инициализация затрат энергии бесконечностью
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.energy));
        energy[0][0] = 0;
        pq.add(new Point(0, 0, 0)); // Начинаем с верхнего левого угла

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            int x = current.x, y = current.y, currEnergy = current.energy;

            // Если мы уже достигли правого нижнего угла, возвращаем результат
            if (x == n - 1 && y == m - 1) {
                return currEnergy;
            }

            // Проверяем все соседние клетки
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // Вычисляем новую энергию
                    int energyCost = Math.max(0, heights[nx][ny] - heights[x][y]);
                    int newEnergy = currEnergy + energyCost;

                    // Если нашли более выгодный путь, обновляем затраты энергии и добавляем в очередь
                    if (newEnergy < energy[nx][ny]) {
                        energy[nx][ny] = newEnergy;
                        pq.add(new Point(nx, ny, newEnergy));
                    }
                }
            }
        }

        return -1; // если путь невозможен
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] heights = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[i][j] = sc.nextInt();
            }
        }

        System.out.println(minEnergy(n, m, heights));
    }
}


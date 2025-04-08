package lab7.SeventhTask;

import java.util.*;

public class SeventhTask {
    static class Edge {
        int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // Количество вершин
        int M = sc.nextInt();  // Количество рёбер
        int S = sc.nextInt();  // Стартовая вершина

        // Чтение рёбер
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        // Алгоритм Беллмана-Форда
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);  // Инициализация расстояний как бесконечность
        dist[S] = 0;  // Расстояние до стартовой вершины равно 0

        // Основной цикл Беллмана-Форда
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }

        // Проверка на отрицательные циклы
        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        // Вывод результата
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("UNREACHABLE ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
    }
}

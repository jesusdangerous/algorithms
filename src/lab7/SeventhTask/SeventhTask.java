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

    public static String getAllWays(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                builder.append("UNREACHABLE ");
            } else {
                builder.append(dist[i]).append(" ");
            }
        }

        return builder.toString().trim();
    }
}

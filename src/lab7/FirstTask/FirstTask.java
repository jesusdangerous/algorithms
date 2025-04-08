package lab7.FirstTask;

import java.util.*;

public class FirstTask {
    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // сжатие пути
            }
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                // объединение по рангу
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
                return true;
            }
            return false;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(other.weight, this.weight); // сортировка по убыванию веса
        }
    }

    public static String maximumSpanningTree(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(u, v, w));
        }

        edges.sort(Comparator.naturalOrder()); // сортируем рёбра по убыванию веса

        UnionFind uf = new UnionFind(n);
        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.u - 1, edge.v - 1)) { // индексы начинаются с 1, а в UnionFind с 0
                totalWeight += edge.weight;
                edgesUsed++;
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        // Если не все вершины подключены, то граф несвязен
        if (edgesUsed != n - 1) {
            return "Oops! I did it again";
        }
        return String.valueOf(totalWeight);
    }
}


package lab7.TenthTask;

import java.util.*;

public class TenthTask {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Set<Integer> stations = new HashSet<>();
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

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int station : stations) {
            minEdge[station] = 0;
            pq.offer(new int[]{station, 0});
        }

        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0];
            int costToConnect = current[1];

            if (visited[city]) continue;
            visited[city] = true;
            totalCost += costToConnect;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && cost[city][i] < minEdge[i]) {
                    minEdge[i] = cost[city][i];
                    pq.offer(new int[]{i, cost[city][i]});
                }
            }
        }

        System.out.println(totalCost);
    }
}
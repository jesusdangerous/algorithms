package lab1.TenthTask;

import java.io.*;
import java.util.StringTokenizer;

public class TenthTask {
//    static int N, K, M;
//    static boolean[][] friends;
//    static int maxCohesion = -1;
//    static int[] bestTeam;
//
//    public static String findFirstTeam(String file) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String result = solve(br);
//        br.close();
//        return result;
//    }
//
//    private static String solve(BufferedReader br) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        friends = new boolean[N][N];
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken()) - 1;
//            int b = Integer.parseInt(st.nextToken()) - 1;
//            friends[a][b] = friends[b][a] = true;
//        }
//
//        bestTeam = new int[K];
//        int[] team = new int[K];
//        generateCombinations(0, 0, team);
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < K; i++) {
//            result.append(bestTeam[i] + 1).append(" ");
//        }
//        return result.toString().trim();
//    }
//
//    private static void generateCombinations(int start, int depth, int[] team) {
//        if (depth == K) {
//            evaluateTeam(team);
//            return;
//        }
//
//        for (int i = start; i < N; i++) {
//            team[depth] = i;
//            generateCombinations(i + 1, depth + 1, team);
//        }
//    }
//
//    private static void evaluateTeam(int[] team1) {
//        boolean[] inTeam1 = new boolean[N];
//        for (int i : team1) inTeam1[i] = true;
//
//        int cohesion1 = 0, cohesion2 = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = i + 1; j < N; j++) {
//                if (friends[i][j]) {
//                    if (inTeam1[i] == inTeam1[j]) {
//                        if (inTeam1[i]) cohesion1++;
//                        else cohesion2++;
//                    }
//                }
//            }
//        }
//
//        int totalCohesion = cohesion1 + cohesion2;
//        if (totalCohesion > maxCohesion) {
//            maxCohesion = totalCohesion;
//            System.arraycopy(team1, 0, bestTeam, 0, K);
//        }
//    }
}

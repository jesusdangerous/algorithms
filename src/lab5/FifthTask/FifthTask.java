package lab5.FifthTask;

import java.util.*;

public class FifthTask {
    static class KDTree {
        private class Node {
            int[] point;
            Node left, right;

            Node(int[] point) {
                this.point = point;
                left = right = null;
            }
        }

        private Node root;
        private int k;

        public KDTree(int k) {
            this.k = k;
            root = null;
        }

        public void insert(int[] point) {
            root = insertRec(root, point, 0);
        }

        private Node insertRec(Node root, int[] point, int depth) {
            if (root == null) {
                return new Node(point);
            }

            int cd = depth % k;

            if (point[cd] < root.point[cd]) {
                root.left = insertRec(root.left, point, depth + 1);
            } else {
                root.right = insertRec(root.right, point, depth + 1);
            }

            return root;
        }

        public List<int[]> rangeSearch(int[] target, double radius) {
            List<int[]> result = new ArrayList<>();
            rangeSearchRec(root, target, radius * radius, result, 0);  // Используем квадрат радиуса для улучшения производительности
            return result;
        }

        private void rangeSearchRec(Node root, int[] target, double radiusSquared, List<int[]> result, int depth) {
            if (root == null) return;

            double distanceSquared = Math.pow(target[0] - root.point[0], 2) + Math.pow(target[1] - root.point[1], 2);
            if (distanceSquared <= radiusSquared) {
                result.add(root.point);
            }

            int cd = depth % k;
            if (target[cd] - radiusSquared < root.point[cd]) {
                rangeSearchRec(root.left, target, radiusSquared, result, depth + 1);
            }

            if (target[cd] + radiusSquared > root.point[cd]) {
                rangeSearchRec(root.right, target, radiusSquared, result, depth + 1);
            }
        }
    }

    public static String getTop(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[][] clients = new int[n][2];
        for (int i = 0; i < n; i++) {
            clients[i][0] = scanner.nextInt();
            clients[i][1] = scanner.nextInt();
        }
        scanner.close();

        KDTree tree = new KDTree(2);
        for (int[] client : clients) {
            tree.insert(client);
        }

        int[] coverage = new int[n];

        // Подсчет покрытия для каждой станции
        for (int i = 0; i < n; i++) {
            int[] station = clients[i];
            List<int[]> neighbors = tree.rangeSearch(station, r);

            for (int[] neighbor : neighbors) {
                for (int j = 0; j < n; j++) {
                    if (Arrays.equals(neighbor, clients[j])) {
                        coverage[i]++;
                        break;
                    }
                }
            }
        }

        List<int[]> stations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (coverage[i] > 0) {
                stations.add(new int[]{i, coverage[i]});
            }
        }

        // Реализация сортировки слиянием
        mergeSort(stations);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.min(10, stations.size()); i++) {
            stringBuilder.append(stations.get(i)[0] + " " + stations.get(i)[1] + "\n");
        }

        return stringBuilder.toString().trim();
    }

    // Реализация сортировки слиянием
    private static void mergeSort(List<int[]> list) {
        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        List<int[]> left = new ArrayList<>(list.subList(0, mid));
        List<int[]> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    // Функция слияния двух отсортированных списков
    private static void merge(List<int[]> list, List<int[]> left, List<int[]> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            int[] leftItem = left.get(i);
            int[] rightItem = right.get(j);

            // Сортировка по количеству обслуживаемых клиентов, если они одинаковы — по индексу
            if (leftItem[1] > rightItem[1] || (leftItem[1] == rightItem[1] && leftItem[0] < rightItem[0])) {
                list.set(k++, leftItem);
                i++;
            } else {
                list.set(k++, rightItem);
                j++;
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}

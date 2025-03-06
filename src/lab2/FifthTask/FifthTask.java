package lab2.FifthTask;

import java.util.ArrayList;
import java.util.Scanner;

public class FifthTask {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int cross(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    static void mergeSort(Point[] points, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(points, left, mid);
            mergeSort(points, mid + 1, right);
            merge(points, left, mid, right);
        }
    }

    static void merge(Point[] points, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Point[] leftArray = new Point[n1];
        Point[] rightArray = new Point[n2];

        System.arraycopy(points, left, leftArray, 0, n1);
        System.arraycopy(points, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].x < rightArray[j].x || (leftArray[i].x == rightArray[j].x && leftArray[i].y < rightArray[j].y)) {
                points[k++] = leftArray[i++];
            } else {
                points[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            points[k++] = leftArray[i++];
        }

        while (j < n2) {
            points[k++] = rightArray[j++];
        }
    }

    static double perimeter(Point[] points) {
        ArrayList<Point> lower = new ArrayList<>();
        for (Point p : points) {
            while (lower.size() >= 2 && cross(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0) {
                lower.removeLast();
            }
            lower.add(p);
        }

        ArrayList<Point> upper = new ArrayList<>();
        for (int i = points.length - 1; i >= 0; i--) {
            Point p = points[i];
            while (upper.size() >= 2 && cross(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
                upper.removeLast();
            }
            upper.add(p);
        }

        lower.removeLast();
        upper.removeLast();

        ArrayList<Point> convexHull = new ArrayList<>(lower);
        convexHull.addAll(upper);

        double perimeter = 0.0;
        for (int i = 0; i < convexHull.size(); i++) {
            Point p1 = convexHull.get(i);
            Point p2 = convexHull.get((i + 1) % convexHull.size());
            perimeter += Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
        }

        return perimeter;
    }

    public static double getPerimeter(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        mergeSort(points, 0, points.length - 1);

        return perimeter(points);
    }
}
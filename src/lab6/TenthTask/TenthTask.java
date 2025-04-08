package lab6.TenthTask;

import java.util.*;

public class TenthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        double[][] sheets = new double[N][2];
        double[][] constSheets = new double[N][2];
        int[] indexes = new int[N];

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            double left = Double.parseDouble(parts[0]);
            double right = Double.parseDouble(parts[1]);
            sheets[i][0] = left;
            sheets[i][1] = right;
            constSheets[i][0] = left;
            constSheets[i][1] = right;
            indexes[i] = i;
        }

        quickSort(sheets, indexes, 0, N - 1);
        double result = solve(sheets, constSheets, indexes, N);

        System.out.printf("%.3f\n", result);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append((indexes[i] + 1) + " ");
        }
        System.out.println(builder.toString().trim());
    }

    public static double solve(double[][] sheets, double[][] constSheets, int[] indexes, int N) {
        double currentTime = 0.0;
        int leftPointer = 0;
        int rightPointer = N - 1;

        while (leftPointer < rightPointer) {
            double leftTime = sheets[indexes[leftPointer]][0];
            double rightTime = sheets[indexes[rightPointer]][1];

            if (leftTime < rightTime) {
                currentTime += leftTime;
                sheets[indexes[rightPointer]][1] -= leftTime;
                leftPointer++;
            } else if (leftTime > rightTime) {
                currentTime += rightTime;
                sheets[indexes[leftPointer]][0] -= rightTime;
                rightPointer--;
            } else {
                currentTime += leftTime;
                leftPointer++;
                rightPointer--;
            }
        }

        if (leftPointer == rightPointer) {
            int leftIndex = indexes[leftPointer];
            double startLeftTime = constSheets[leftIndex][0];
            double startRightTime = constSheets[leftIndex][1];
            double leftTime = sheets[leftIndex][0];
            double rightTime = sheets[leftIndex][1];

            double s = 1.0;
            double leftV = s / startLeftTime;
            double rightV = s / startRightTime;
            double overallV = leftV + rightV;
            s -= (startLeftTime - leftTime) / startLeftTime;
            s -= (startRightTime - rightTime) / startRightTime;

            currentTime += s / overallV;
        }

        return currentTime;
    }

    public static void quickSort(double[][] arr, int[] ind, int low, int high) {
        if (low < high) {
            int mid = partition(arr, ind, low, high);
            quickSort(arr, ind, low, mid - 1);
            quickSort(arr, ind, mid + 1, high);
        }
    }

    public static int partition(double[][] arr, int[] ind, int low, int high) {
        double pivot = arr[ind[high]][0] / arr[ind[high]][1];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            double leftDiff = arr[ind[j]][0] / arr[ind[j]][1];
            if (leftDiff >= pivot) {
                i++;
                int temp = ind[i];
                ind[i] = ind[j];
                ind[j] = temp;
            }
        }

        int temp = ind[i + 1];
        ind[i + 1] = ind[high];
        ind[high] = temp;

        return i + 1;
    }
}

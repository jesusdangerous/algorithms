package lab2.TenthTask;

import java.util.ArrayList;
import java.util.Scanner;

public class TenthTask {
    private static int count;
    private static ArrayList<String> operations;

    public static void findOperations(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] chairs = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                chairs[i][j] = scanner.nextInt();
            }
        }

        int[] row = new int[rows];
        for (int i = 0; i < rows; i++) {
            row[i] = chairs[i][0];
        }

        operations = new ArrayList<>();

        sort(chairs[0], "C");
        sort(row, "R");

        System.out.println(count);
        for (String operation : operations) {
            System.out.println(operation);
        }
    }

    private static void sort(int[] arr, String operation) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                count++;
                operations.add(operation + " " + (i + 1) + " " + (minIndex + 1));
            }
        }
    }
}

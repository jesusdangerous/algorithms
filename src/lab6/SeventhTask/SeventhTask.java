package lab6.SeventhTask;

import java.util.Scanner;

public class SeventhTask {
    public static int getMaxCount(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] talks = new int[n][2];
        for (int i = 0; i < n; i++) {
            talks[i][0] = scanner.nextInt();
            talks[i][1] = scanner.nextInt();
        }

        sortByEndTime(talks);

        int count = 0;
        int lastEnd = 0;

        for (int[] talk : talks) {
            if (talk[0] >= lastEnd + 1) {
                count++;
                lastEnd = talk[1];
            }
        }

        return count;
    }

    public static void sortByEndTime(int[][] talks) {
        int n = talks.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (talks[j][1] > talks[j + 1][1]) {
                    int[] temp = talks[j];
                    talks[j] = talks[j + 1];
                    talks[j + 1] = temp;
                }
            }
        }
    }
}

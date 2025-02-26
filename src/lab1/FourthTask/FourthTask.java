package lab1.FourthTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FourthTask {
    public static int findCountCommonElements(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String[] sizes = reader.readLine().split(" ");
        int N1 = Integer.parseInt(sizes[0]);
        int N2 = Integer.parseInt(sizes[1]);

        int[] array1 = new int[N1];
        for (int i = 0; i < N1; i++) {
            array1[i] = Integer.parseInt(reader.readLine());
        }

        int[] array2 = new int[N2];
        for (int i = 0; i < N2; i++) {
            array2[i] = Integer.parseInt(reader.readLine());
        }

        return findCountCommonElements(array1, array2);
    }

    private static int findCountCommonElements(int[] array1, int[] array2) {
        int i = 0, j = 0, count = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                count++;
                i++;
                j++;
            } else if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}

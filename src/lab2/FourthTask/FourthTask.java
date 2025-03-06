package lab2.FourthTask;

import java.util.ArrayList;
import java.util.Scanner;

public class FourthTask {
    public static String findPriority(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] priority = new int[k];
        for (int i = 0; i < k; i++) {
            priority[i] = scanner.nextInt() - 1;
        }

        ArrayList<Record> records = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int[] attributes = new int[k];
            for (int j = 0; j < k; j++) {
                attributes[j] = scanner.nextInt();
            }
            records.add(new Record(name, attributes));
        }

        customSort(records, priority);

        StringBuilder result = new StringBuilder();
        for (Record record : records) {
            result.append(record.name).append(" ");
        }

        return result.toString().trim();
    }

    static void customSort(ArrayList<Record> records, int[] priority) {
        quickSort(records, 0, records.size() - 1, priority);
    }

    static void quickSort(ArrayList<Record> records, int low, int high, int[] priority) {
        if (low < high) {
            int pi = partition(records, low, high, priority);
            quickSort(records, low, pi - 1, priority);
            quickSort(records, pi + 1, high, priority);
        }
    }

    static int partition(ArrayList<Record> records, int low, int high, int[] priority) {
        Record pivot = records.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(records.get(j), pivot, priority) > 0) {
                i++;
                swap(records, i, j);
            }
        }
        swap(records, i + 1, high);
        return i + 1;
    }

    static void swap(ArrayList<Record> records, int i, int j) {
        Record temp = records.get(i);
        records.set(i, records.get(j));
        records.set(j, temp);
    }

    static int compare(Record r1, Record r2, int[] priority) {
        for (int index : priority) {
            if (r1.attributes[index] != r2.attributes[index]) {
                return Integer.compare(r1.attributes[index], r2.attributes[index]);
            }
        }
        return 0;
    }

    static class Record {
        private final String name;
        private final int[] attributes;

        Record(String name, int[] attributes) {
            this.name = name;
            this.attributes = attributes;
        }
    }
}

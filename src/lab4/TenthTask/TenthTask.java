package lab4.TenthTask;

import java.util.Scanner;

public class TenthTask {
    static class HashMap {
        private static final int CAPACITY = 10007;
        private Node[] buckets;

        public HashMap() {
            buckets = new Node[CAPACITY];
        }

        static class Node {
            String key;
            int value;
            Node next;

            Node(String key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int hash(String key) {
            return Math.abs(key.hashCode()) % CAPACITY;
        }

        public void put(String key) {
            int index = hash(key);
            Node current = buckets[index];

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value++;
                    return;
                }
                current = current.next;
            }

            Node newNode = new Node(key, 1);
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }

        public int size() {
            int count = 0;
            for (Node bucket : buckets) {
                Node current = bucket;
                while (current != null) {
                    count++;
                    current = current.next;
                }
            }
            return count;
        }
    }

    private static String countingSort(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'A']++;
        }

        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted.append((char) ('A' + i));
            }
        }
        return sorted.toString();
    }

    public static int getNormalizedWords(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        HashMap normalizedWords = new HashMap();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine().trim();
            String sortedWord = countingSort(word);
            normalizedWords.put(sortedWord);
        }

        return normalizedWords.size();
    }
}

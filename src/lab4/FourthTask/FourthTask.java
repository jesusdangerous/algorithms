package lab4.FourthTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthTask {
    public static List<String> findCompositeStrings(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine().trim();
        }

        SuffixTree suffixTree = new SuffixTree();
        List<String> results = new ArrayList<>();

        for (String word : words) {
            suffixTree.insert(word);
        }

        for (String word1 : words) {
            for (String word2 : words) {
                String combined = word1 + word2;
                if (suffixTree.search(combined) && !results.contains(combined)) {
                    results.add(combined);
                }
            }
        }

        QuickSort.quickSort(results, 0, results.size() - 1);
        return results;
    }
}
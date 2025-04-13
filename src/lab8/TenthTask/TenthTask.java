package lab8.TenthTask;

import java.util.*;

public class TenthTask {
    public static List<String> solveLastJackWord(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        String jackWord = scanner.nextLine();

        String combined = original + "*" + jackWord;
        int[] prefix = computePrefixFunction(combined);

        int originalLength = original.length();
        int jackWordLength = jackWord.length();
        List<Integer> positions = new ArrayList<>();
        int pos = jackWordLength - 1;

        while (prefix[originalLength + 1 + pos] > 0) {
            pos -= prefix[originalLength + 1 + pos];
            positions.add(pos + 1);
        }


        List<String> answer = new ArrayList<>();
        if (pos != -1) {
            answer.add("Yes");
        } else {
            answer.add("No");
            StringBuilder result = new StringBuilder();

            for (int i = positions.size() - 1; i > 0; i--) {
                result.append(jackWord.substring(positions.get(i), positions.get(i - 1))).append(" ");
            }
            result.append(jackWord.substring(positions.get(0)));

            answer.add(result.toString());
        }

        return answer;
    }

    private static int[] computePrefixFunction(String s) {
        int[] prefix = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = prefix[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            prefix[i] = k;
        }
        return prefix;
    }
}

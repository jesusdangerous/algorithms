package lab8.FirstTask;

import java.util.*;

public class FirstTask {
    public static String getLargestCommonPrefix(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] packed = new String[n];
        for (int i = 0; i < n; i++) {
            packed[i] = sc.nextLine();
        }

        String prefix = unpack(packed[0], "");
        for (int i = 1; i < n; i++) {
            prefix = unpack(packed[i], prefix);
            if (prefix.isEmpty()) break;
        }

        return prefix;
    }

    static String unpack(String s, String currentPrefix) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int maxLength = currentPrefix.length();

        while (i < s.length() && (currentPrefix.isEmpty() || result.length() < maxLength)) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (!currentPrefix.isEmpty() &&
                        (result.length() >= maxLength || ch != currentPrefix.charAt(result.length()))) {
                    return result.toString();
                }
                result.append(ch);
                i++;
            } else if (Character.isDigit(ch)) {
                int repeatCount = ch - '0';
                i++;
                if (s.charAt(i) == '[') {
                    int bracketBalance = 1;
                    i++;
                    int start = i;
                    while (i < s.length() && bracketBalance > 0) {
                        if (s.charAt(i) == '[') bracketBalance++;
                        else if (s.charAt(i) == ']') bracketBalance--;
                        i++;
                    }
                    String inner = unpack(
                            s.substring(start, i - 1),
                            currentPrefix.isEmpty() ? "" : currentPrefix.substring(result.length())
                    );
                    for (int rep = 0; rep < repeatCount && (currentPrefix.isEmpty() || result.length() < maxLength); rep++) {
                        for (int j = 0; j < inner.length(); j++) {
                            char c = inner.charAt(j);
                            if (!currentPrefix.isEmpty() &&
                                    (result.length() >= maxLength || c != currentPrefix.charAt(result.length()))) {
                                return result.toString();
                            }
                            result.append(c);
                        }
                    }
                }
            }
        }

        return result.toString();
    }
}


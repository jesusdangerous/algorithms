package lab5.FourthTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthTask {
    public static List<Integer> isPerfectSquare(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String numberStr = scanner.nextLine().trim();
            if (isSquare(numberStr)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean isSquare(String numberStr) {
        String left = "1";
        String right = numberStr;

        while (compareStrings(left, right) <= 0) {
            String mid = divideByTwo(addStrings(left, right));
            String square = multiplyStrings(mid, mid);

            int cmp = compareStrings(square, numberStr);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                left = addStrings(mid, "1");
            } else {
                right = subtractStrings(mid, "1");
            }
        }
        return false;
    }

    private static int compareStrings(String a, String b) {
        if (a.length() != b.length()) {
            return Integer.compare(a.length(), b.length());
        }
        return a.compareTo(b);
    }

    private static String addStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }

    private static String subtractStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int borrow = 0, i = a.length() - 1, j = b.length() - 1;

        while (i >= 0) {
            int diff = (a.charAt(i) - '0') - (j >= 0 ? (b.charAt(j--) - '0') : 0) - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
            i--;
        }

        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.setLength(result.length() - 1);
        }

        return result.reverse().toString();
    }

    private static String multiplyStrings(String a, String b) {
        int[] result = new int[a.length() + b.length()];

        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder resultStr = new StringBuilder();
        for (int num : result) {
            if (!(resultStr.isEmpty() && num == 0)) {
                resultStr.append(num);
            }
        }

        return resultStr.isEmpty() ? "0" : resultStr.toString();
    }

    private static String divideByTwo(String num) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (char c : num.toCharArray()) {
            int current = carry * 10 + (c - '0');
            result.append(current / 2);
            carry = current % 2;
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}

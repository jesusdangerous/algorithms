package lab1.FifthTask;

public class FifthTask {
    public static String calculateLongNumbers(String num1, String operation, String num2) {
        boolean isNegative1 = num1.startsWith("-");
        boolean isNegative2 = num2.startsWith("-");

        if (isNegative1) num1 = num1.substring(1);
        if (isNegative2) num2 = num2.substring(1);

        int[] a = new int[1001];
        int[] b = new int[1001];
        int[] c = new int[1001];

        convert(a, num1);
        convert(b, num2);

        boolean resultNegative;

        if ("+".equals(operation)) {
            if (isNegative1 == isNegative2) {
                sum(a, b, c);
                resultNegative = isNegative1;
            } else {
                if (compareAbs(a, b) >= 0) {
                    subtract(a, b, c);
                    resultNegative = isNegative1;
                } else {
                    subtract(b, a, c);
                    resultNegative = isNegative2;
                }
            }
        } else if ("-".equals(operation)) {
            if (isNegative1 != isNegative2) {
                sum(a, b, c);
                resultNegative = isNegative1;
            } else {
                if (compareAbs(a, b) >= 0) {
                    subtract(a, b, c);
                    resultNegative = isNegative1;
                } else {
                    subtract(b, a, c);
                    resultNegative = !isNegative1;
                }
            }
        } else {
            throw new IllegalArgumentException("Неверная операция: " + operation);
        }

        StringBuilder result = new StringBuilder();
        if (resultNegative && !(c[0] == 1 && c[1] == 0)) {
            result.append("-");
        }
        for (int i = c[0]; i > 0; i--) {
            result.append(c[i]);
        }
        return result.toString();
    }

    private static void convert(int[] a, String number) {
        a[0] = number.length();
        for (int i = 0; i < a[0]; i++) {
            a[i + 1] = number.charAt(number.length() - 1 - i) - '0';
        }
    }

    private static void sum(int[] a, int[] b, int[] c) {
        int carry = 0;
        c[0] = Math.max(a[0], b[0]);

        for (int i = 1; i <= c[0]; i++) {
            c[i] = a[i] + b[i] + carry;
            carry = c[i] / 10;
            c[i] %= 10;
        }

        if (carry > 0) {
            c[0]++;
            c[c[0]] = carry;
        }
    }

    private static void subtract(int[] a, int[] b, int[] c) {
        int borrow = 0;
        c[0] = a[0];

        for (int i = 1; i <= c[0]; i++) {
            c[i] = a[i] - b[i] - borrow;
            if (c[i] < 0) {
                c[i] += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
        }

        while (c[0] > 1 && c[c[0]] == 0) {
            c[0]--;
        }
    }

    private static int compareAbs(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        }
        for (int i = a[0]; i > 0; i--) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }
        return 0;
    }
}

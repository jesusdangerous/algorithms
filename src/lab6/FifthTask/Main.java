package lab6.FifthTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();

        StringBuilder result = new StringBuilder();

        result.append(numerator / denominator);
        numerator %= denominator;

        if (numerator == 0) {
            System.out.println(result);
            return;
        }

        result.append(".");

        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        StringBuilder decimalPart = new StringBuilder();
        int index = 0;
        boolean repeating = false;
        int repeatStart = 0;

        while (numerator != 0) {
            numerator *= 10;
            if (remainderIndexMap.containsKey(numerator)) {
                repeatStart = remainderIndexMap.get(numerator);
                repeating = true;
                break;
            }

            remainderIndexMap.put(numerator, index);
            decimalPart.append(numerator / denominator);
            numerator %= denominator;
            index++;
        }

        if (repeating) {
            result.append(decimalPart.substring(0, repeatStart))
                    .append("(")
                    .append(decimalPart.substring(repeatStart))
                    .append(")");
        } else {
            result.append(decimalPart);
        }

        System.out.println(result);
    }
}

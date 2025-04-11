package lab6.FifthTask;


public class FifthTask {
    public static String getDecimalRepresentation(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();

        result.append(numerator / denominator);
        numerator %= denominator;

        if (numerator == 0) {
            return result.toString();
        }

        result.append(".");

        HashMap<Integer, Integer> remainderIndexMap = new HashMap<>();
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

        return result.toString();
    }
}

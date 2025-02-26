package lab1.FirstTask;

public class FirstTask {
    public static String findNearestDistances(String length, String placeNumbers) {
        int lengthStreet = Integer.parseInt(length);
        int[] numbers = new int[lengthStreet];
        int i = 0;
        for (String number : placeNumbers.split(" ")) {
            numbers[i] = Integer.parseInt(number);
            i++;
        }

        int[] distances = new int[lengthStreet];

        int lastZeroIndex = -1;
        for (i = 0; i < lengthStreet; i++) {
            if (numbers[i] == 0) {
                lastZeroIndex = i;
                distances[i] = 0;
            } else if (lastZeroIndex != -1) {
                distances[i] = i - lastZeroIndex;
            } else {
                distances[i] = Integer.MAX_VALUE;
            }
        }

        lastZeroIndex = -1;
        for (i = lengthStreet - 1; i >= 0; i--) {
            if (numbers[i] == 0) {
                lastZeroIndex = i;
            } else if (lastZeroIndex != -1 && distances[i] > lastZeroIndex - i) {
                distances[i] = lastZeroIndex - i;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int distance : distances) {
            answer.append(distance).append(" ");
        }

        return answer.toString().trim();
    }
}

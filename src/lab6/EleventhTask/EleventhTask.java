package lab6.EleventhTask;

public class EleventhTask {
    private static int levDiv(int i, int j, String s1, String s2, int[][] matrix) {
        if (i == 0 && j == 0) {
            return 0;
        } else if (i > 0 && j == 0) {
            return i;
        } else if (i == 0 && j > 0) {
            return j;
        }

        int m = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

        int min = matrix[i][j - 1] + 1;
        if (matrix[i - 1][j] + 1 < min) {
            min = matrix[i - 1][j - 1];
        }
        if (matrix[i - 1][j - 1] + m < min) {
            min = matrix[i - 1][j - 1] + m;
        }

        return min;
    }

    public static int levenshteinDistance(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                matrix[i][j] = levDiv(i, j, s1, s2, matrix);
            }
        }

        return matrix[s1.length()][s2.length()];
    }
}

package lab8.FifthTask;


public class FifthTask {
    public static String getPalindrome(String line) {
        if (line.length() == 1) {
            System.out.println(line + line);
            return line + line;
        } else {
            for (int i = 1; i < line.length(); i++) {
                String subString = line.substring(i);
                if (isPalindrome(subString)){
                    StringBuilder sb = new StringBuilder(line.substring(0, i));
                    return line + sb.reverse();
                }
            }
        }
        return line;
    }

    private static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }
}


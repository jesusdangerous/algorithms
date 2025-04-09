package lab8.FifthTask;

import java.util.Scanner;

public class FifthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if (line.length() == 1)
            System.out.println(line + line);
        else
            for (int i = 1; i < line.length(); i++){
                String subString = line.substring(i);
                if (isPalindrome(subString)){
                    StringBuilder sb = new StringBuilder(line.substring(0, i));
                    System.out.println(line + sb.reverse());
                    break;
                }
            }
    }

    private static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }
}


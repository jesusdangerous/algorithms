package lab3.SeventhTask;

import lab3.FourthTask.Stack;
import lab3.FourthTask.StackException;

public class SeventhTask {
    public static double reversePolishNotation(String input) throws StackException {
        String[] strings = input.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String string : strings) {
            if (isNumber(string)) {
                stack.push(Double.parseDouble(string));
            } else {
                double tmp2 = stack.pop();
                double tmp1 = stack.pop();

                switch (string) {
                    case "*":
                        stack.push(tmp1 * tmp2);
                        break;
                    case "+":
                        stack.push(tmp1 + tmp2);
                        break;
                    case "-":
                        stack.push(tmp1 - tmp2);
                        break;
                    case "/":
                        stack.push(tmp1 / tmp2);
                        break;
                }
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            System.out.println("error");
            return -1;
        }
    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

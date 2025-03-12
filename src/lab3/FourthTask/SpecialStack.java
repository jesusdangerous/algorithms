package lab3.FourthTask;

public class SpecialStack {
    private final Stack<Integer> stack;
    private int minElement;

    public SpecialStack() {
        stack = new Stack<>();
    }

    public void push(int value) throws StackException {
        if (stack.isEmpty()) {
            minElement = value;
            stack.push(value);
        } else if (value < minElement) {
            stack.push(2 * value - minElement);
            minElement = value;
        } else {
            stack.push(value);
        }
    }

    public int pop() throws StackException {
        if (stack.isEmpty()) {
            throw new StackException();
        }

        int top = stack.pop();

        if (top < minElement) {
            int originalMin = minElement;
            minElement = 2 * minElement - top;
            return originalMin;
        } else {
            return top;
        }
    }

    public int peek() throws StackException {
        if (stack.isEmpty()) {
            throw new StackException();
        }

        int top = stack.peek();
        return (top < minElement) ? minElement : top;
    }

    public int getMinElement() throws StackException {
        if (stack.isEmpty()) {
            throw new StackException();
        }

        return minElement;
    }
}

package lab3.FourthTask;

public class SpecialQueue {
    private final SpecialStack stack1;
    private final SpecialStack stack2;

    public SpecialQueue() {
        stack1 = new SpecialStack();
        stack2 = new SpecialStack();
    }

    public void enqueue(int value) throws StackException {
        stack1.push(value);
    }

    public int dequeue() throws StackException {
        if (stack2IsEmpty()) {
            while (!stack1IsEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2IsEmpty()) {
            throw new StackException();
        }
        return stack2.pop();
    }

    public int front() throws StackException {
        if (stack2IsEmpty()) {
            while (!stack1IsEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2IsEmpty()) {
            throw new StackException();
        }
        return stack2.peek();
    }

    public int getMinimum() throws StackException {
        if (stack1IsEmpty() && stack2IsEmpty()) {
            throw new StackException();
        } else if (stack1IsEmpty()) {
            return stack2.getMinElement();
        } else if (stack2IsEmpty()) {
            return stack1.getMinElement();
        } else {
            return Math.min(stack1.getMinElement(), stack2.getMinElement());
        }
    }

    private boolean stack1IsEmpty() {
        try {
            stack1.peek();
            return false;
        } catch (StackException e) {
            return true;
        }
    }

    private boolean stack2IsEmpty() {
        try {
            stack2.peek();
            return false;
        } catch (StackException e) {
            return true;
        }
    }
}

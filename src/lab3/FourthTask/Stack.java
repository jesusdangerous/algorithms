package lab3.FourthTask;

public class Stack<T> {
    private int capacity;
    private T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    @SuppressWarnings("unchecked")
    public Stack() {
        capacity = 1000;
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T value) throws StackException {
        if (top == capacity - 1) {
            throw new StackException();
        }
        stack[++top] = value;
    }

    public T pop() throws StackException {
        if (top == -1) {
            throw new StackException();
        }
        return stack[top--];
    }

    public T peek() throws StackException {
        if (top == -1) {
            throw new StackException();
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }
}

package lab3.FirstTask;

public class Deque<T> {
    private final T[] deque;
    private final int capacity;
    private int size;
    private int front;
    private int back;

    @SuppressWarnings("unchecked")
    public Deque(int capacity) {
        this.capacity = capacity;
        this.deque = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void pushBack(T value) throws DequeException {
        if (size == capacity) {
            throw new DequeException();
        }
        deque[back] = value;
        back = (back + 1) % capacity;
        size++;
    }

    public void pushFront(T value) throws DequeException {
        if (size == capacity) {
            throw new DequeException();
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
    }

    public T popBack() throws DequeException {
        if (size == 0) {
            throw new DequeException();
        }
        back = (back - 1 + capacity) % capacity;
        T value = deque[back];
        size--;
        return value;
    }

    public T popFront() throws DequeException {
        if (size == 0) {
            throw new DequeException();
        }
        T value = deque[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }
}
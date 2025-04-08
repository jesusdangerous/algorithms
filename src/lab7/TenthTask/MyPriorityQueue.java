package lab7.TenthTask;

import java.util.ArrayList;
import java.util.List;

class MyPriorityQueue {
    private List<int[]> heap;

    public MyPriorityQueue() {
        heap = new ArrayList<>();
    }

    public void offer(int[] element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    public int[] poll() {
        if (heap.size() == 0) return null;
        int[] result = heap.get(0);
        int[] last = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, last);
            siftDown(0);
        }
        return result;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void siftUp(int index) {
        int[] element = heap.get(index);
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            int[] parent = heap.get(parentIndex);
            if (parent[1] <= element[1]) break;
            heap.set(index, parent);
            index = parentIndex;
        }
        heap.set(index, element);
    }

    private void siftDown(int index) {
        int[] element = heap.get(index);
        int size = heap.size();

        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < size && heap.get(leftChildIndex)[1] < heap.get(smallest)[1]) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex < size && heap.get(rightChildIndex)[1] < heap.get(smallest)[1]) {
                smallest = rightChildIndex;
            }
            if (smallest == index) break;

            heap.set(index, heap.get(smallest));
            index = smallest;
        }

        heap.set(index, element);
    }
}

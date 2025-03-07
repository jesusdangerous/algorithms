package lab2.SeventhTask;

import java.io.*;
import java.util.ArrayList;

public class SeventhTask {
    private static final int CHUNK_SIZE = 100_000;

    public static void getSortedFile(String input, String output) throws IOException {
        externalSort(input, output);
    }

    private static void externalSort(String inputFile, String outputFile) throws IOException {
        ArrayList<File> sortedChunks = splitAndSortChunks(inputFile);
        mergeChunks(sortedChunks, outputFile);
    }

    private static ArrayList<File> splitAndSortChunks(String inputFile) throws IOException {
        ArrayList<File> chunkFiles = new ArrayList<>();
        ArrayList<String> chunk = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                chunk.add(line);
                if (chunk.size() >= CHUNK_SIZE) {
                    chunkFiles.add(writeSortedChunk(chunk));
                    chunk.clear();
                }
            }
            if (!chunk.isEmpty()) {
                chunkFiles.add(writeSortedChunk(chunk));
            }
        }
        return chunkFiles;
    }

    private static File writeSortedChunk(ArrayList<String> chunk) throws IOException {
        quickSort(chunk, 0, chunk.size() - 1);
        File tempFile = File.createTempFile("sorted_chunk", ".txt");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String line : chunk) {
                writer.write(line);
                writer.newLine();
            }
        }
        return tempFile;
    }

    private static void quickSort(ArrayList<String> arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(ArrayList<String> arr, int left, int right) {
        String pivot = arr.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(ArrayList<String> arr, int i, int j) {
        String temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private static void mergeChunks(ArrayList<File> chunkFiles, String outputFile) throws IOException {
        CustomPriorityQueue<FileBuffer> pq = new CustomPriorityQueue<>();
        for (File file : chunkFiles) {
            FileBuffer buffer = new FileBuffer(file);
            if (!buffer.isEmpty()) {
                pq.add(buffer);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            while (!pq.isEmpty()) {
                FileBuffer buffer = pq.poll();
                writer.write(buffer.pop());
                writer.newLine();

                if (!buffer.isEmpty()) {
                    pq.add(buffer);
                } else {
                    buffer.close();
                }
            }
        }
    }

    private static class FileBuffer implements Comparable<FileBuffer>, Closeable {
        private final BufferedReader reader;
        private String currentLine;

        public FileBuffer(File file) throws IOException {
            this.reader = new BufferedReader(new FileReader(file));
            this.currentLine = reader.readLine();
        }

        public boolean isEmpty() {
            return currentLine == null;
        }

        public String pop() throws IOException {
            String result = currentLine;
            currentLine = reader.readLine();
            return result;
        }

        @Override
        public int compareTo(FileBuffer other) {
            return this.currentLine.compareTo(other.currentLine);
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }

    private static class CustomPriorityQueue<T extends Comparable<T>> {
        private final ArrayList<T> heap = new ArrayList<>();

        public void add(T item) {
            heap.add(item);
            heapifyUp();
        }

        public T poll() {
            if (heap.isEmpty()) return null;
            T root = heap.getFirst();
            T last = heap.removeLast();
            if (!heap.isEmpty()) {
                heap.set(0, last);
                heapifyDown();
            }
            return root;
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        private void heapifyUp() {
            int index = heap.size() - 1;
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) break;
                swap(index, parentIndex);
                index = parentIndex;
            }
        }

        private void heapifyDown() {
            int index = 0;
            while (2 * index + 1 < heap.size()) {
                int smallerChild = 2 * index + 1;
                int rightChild = smallerChild + 1;
                if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallerChild)) < 0) {
                    smallerChild = rightChild;
                }
                if (heap.get(index).compareTo(heap.get(smallerChild)) <= 0) break;
                swap(index, smallerChild);
                index = smallerChild;
            }
        }

        private void swap(int i, int j) {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}

package lab2.SeventhTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SeventhTask {
    private static final int CHUNK_SIZE = 100_000;

    public static void main(String[] args) throws IOException {
        externalSort("input.txt", "output.txt");
    }

    public static void externalSort(String inputFile, String outputFile) throws IOException {
        List<File> sortedChunks = splitAndSortChunks(inputFile);
        mergeChunks(sortedChunks, outputFile);
    }

    private static List<File> splitAndSortChunks(String inputFile) throws IOException {
        List<File> chunkFiles = new ArrayList<>();
        List<String> chunk = new ArrayList<>();

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

    private static File writeSortedChunk(List<String> chunk) throws IOException {
        chunk.sort(String::compareTo);
        File tempFile = File.createTempFile("sorted_chunk_", ".txt");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            for (String line : chunk) {
                writer.write(line);
                writer.newLine();
            }
        }
        return tempFile;
    }

    private static void mergeChunks(List<File> chunkFiles, String outputFile) throws IOException {
        PriorityQueue<FileBuffer> pq = new PriorityQueue<>();
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

        for (FileBuffer buffer : pq) {
            buffer.close();
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
}

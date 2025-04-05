package lab5.FifthTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TestFifthTask {
    @Test
    void test1() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String input = "5 3\n" +
                "0 0\n" +
                "1 1\n" +
                "2 2\n" +
                "3 3\n" +
                "4 4";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String answer = FifthTask.getTop(new String[]{});

        System.setOut(originalOut);
        System.setIn(originalIn);

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 1");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals("2 5\n" +
                "1 4\n" +
                "3 4\n" +
                "0 3\n" +
                "4 3", answer);
        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 16, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }

    @Test
    void test2() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String input = "4 2\n" +
                "1 1\n" +
                "2 2\n" +
                "3 3\n" +
                "4 4";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String answer = FifthTask.getTop(new String[]{});

        System.setOut(originalOut);
        System.setIn(originalIn);

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 2");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals("1 3\n" +
                "2 3\n" +
                "0 2\n" +
                "3 2", answer);
        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 16, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

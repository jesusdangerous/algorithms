package lab2.FourthTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestFourthTask {
    @Test
    void test1() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String input = "3\n3\n2 1 3\nA 1 2 3\nB 3 2 1\nC 3 1 2\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String answer = FourthTask.findPriority(new String[]{});

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

        Assertions.assertEquals("B A C", answer);
        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 64, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
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

        String input = "7\n4\n4 3 2 1\n"
                + "A 3 1 4 4\n"
                + "B 3 2 4 4\n"
                + "C 3 2 3 4\n"
                + "D 3 3 3 3\n"
                + "E 3 4 3 2\n"
                + "F 3 3 1 2\n"
                + "G 3 3 2 1\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String answer = FourthTask.findPriority(new String[]{});

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

        Assertions.assertEquals("B A C D E F G", answer);
        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 64, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

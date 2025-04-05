package lab5.FourthTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

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

        String input = "3\n" +
                "16\n" +
                "15\n" +
                "25";

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> answer = FourthTask.isPerfectSquare(new String[]{});

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


        Assertions.assertEquals(List.of(1, 3), answer);
        Assertions.assertTrue(elapsed < 1000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 256, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
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

        String input = "5\n" +
                "9\n" +
                "8\n" +
                "49\n" +
                "100\n" +
                "50";

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> answer = FourthTask.isPerfectSquare(new String[]{});

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


        Assertions.assertEquals(List.of(1, 3, 4), answer);
        Assertions.assertTrue(elapsed < 1000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 256, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

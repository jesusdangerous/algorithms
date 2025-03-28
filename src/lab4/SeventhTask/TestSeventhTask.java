package lab4.SeventhTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class TestSeventhTask {
    @Test
    void test1() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String input = "10 8\n" +
                "1\n" +
                "7\n" +
                "15\n" +
                "8\n" +
                "9\n" +
                "15\n" +
                "15\n" +
                "19\n" +
                "5\n" +
                "19\n" +
                "1 1 8\n" +
                "1 6 8\n" +
                "1 0 6\n" +
                "2 6 6\n" +
                "2 1 6\n" +
                "2 0 9\n" +
                "1 4 7\n" +
                "1 3 6";

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> answer = SeventhTask.processQueries(new String[]{});

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

        Assertions.assertEquals(List.of(93, 39, 70, 49, 38), answer);
        Assertions.assertTrue(elapsed < 500, "Метод выполняется слишком долго: " + elapsed + " мс");
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

        String input = "5 5\n" +
                "10\n" +
                "20\n" +
                "30\n" +
                "40\n" +
                "50\n" +
                "1 0 4\n" +  // Сумма от 10 до 50
                "1 1 3\n" +  // Сумма от 20 до 40
                "2 2 100\n" + // Изменяем 3-й элемент на 100
                "1 0 4\n" +  // Сумма от 10 до 100 (изменено)
                "1 2 4";     // Сумма от 100 до 50

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> answer = SeventhTask.processQueries(new String[]{});

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

        Assertions.assertEquals(List.of(150, 90, 220, 190), answer);
        Assertions.assertTrue(elapsed < 500, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 16, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }

    @Test
    void test3() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String input = "10 10\n" +
                "68\n" +
                "24\n" +
                "72\n" +
                "2\n" +
                "88\n" +
                "26\n" +
                "5\n" +
                "60\n" +
                "104\n" +
                "56\n" +
                "2 4 22\n" +
                "1 9 8\n" +
                "1 4 9\n" +
                "2 9 38\n" +
                "2 5 9\n" +
                "2 4 81\n" +
                "1 9 8\n" +
                "2 7 37\n" +
                "2 0 107\n" +
                "2 0 110";

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> answer = SeventhTask.processQueries(new String[]{});

        System.setOut(originalOut);
        System.setIn(originalIn);


        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 3");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals(List.of(160, 273, 142), answer);
        Assertions.assertTrue(elapsed < 500, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 16, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

package lab7.TenthTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestTenthTask {
    @Test
    void test1() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String input = "4 2\n" +
                "1 4\n" +
                "0 2 4 3\n" +
                "2 0 5 2\n" +
                "4 5 0 1\n" +
                "3 2 1 0";

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int answer = TenthTask.getMinCost(new String[]{});

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

        Assertions.assertEquals(3, answer);
        Assertions.assertTrue(elapsed < 1000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 256, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

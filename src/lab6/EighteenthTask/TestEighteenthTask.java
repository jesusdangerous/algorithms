package lab6.EighteenthTask;

import lab6.FifthTask.FifthTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestEighteenthTask {
    @Test
    void test1() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        int answer = EighteenthTask.getNumber(2, 10);

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 1");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals(90, answer);
        Assertions.assertTrue(elapsed < 1000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 256, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }

    @Test
    void test2() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        int answer = EighteenthTask.getNumber(3, 4);

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 2");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals(45, answer);
        Assertions.assertTrue(elapsed < 1000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 256, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

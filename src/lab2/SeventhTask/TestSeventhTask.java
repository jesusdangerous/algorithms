package lab2.SeventhTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestSeventhTask {
    @Test
    void test1() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        //int answer = SeventhTask.getSortedStrings("C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\data_for_first_test");

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 1");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        //Assertions.assertEquals(2, answer);
        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 2, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

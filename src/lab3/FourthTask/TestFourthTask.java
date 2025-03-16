package lab3.FourthTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFourthTask {
    @Test
    void test1() throws StackException {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        SpecialQueue queue = new SpecialQueue();
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(7);

        int a = queue.getMinimum();

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 1");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals(3, a);
        int b = queue.dequeue();

        Assertions.assertEquals(3, a);

        int c = queue.dequeue();

        Assertions.assertEquals(7, queue.getMinimum());
    }
}

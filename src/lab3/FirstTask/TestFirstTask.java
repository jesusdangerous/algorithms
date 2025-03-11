package lab3.FirstTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFirstTask {
    @Test
    void test1() throws DequeException {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        Deque<Integer> deque = new Deque<>(4);
        deque.pushFront(861);
        deque.pushFront(-819);
        int a = deque.popBack();
        int b = deque.popBack();

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 1");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals(861, a);
        Assertions.assertEquals(-819, b);
        Assertions.assertTrue(elapsed < 1000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 64, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }

    @Test
    void test2() throws DequeException {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        Deque<Integer> deque = new Deque<>(7);
        deque.pushFront(-855);
        deque.pushFront(720);
        int a = deque.popBack();
        int b = deque.popBack();
        deque.pushBack(844);
        int c = deque.popBack();
        deque.pushBack(823);


        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 2");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        Assertions.assertEquals(-855, a);
        Assertions.assertEquals(720, b);
        Assertions.assertEquals(844, c);
        Assertions.assertTrue(elapsed < 1000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 64, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

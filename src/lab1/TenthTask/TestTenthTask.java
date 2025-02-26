//package lab1.TenthTask;
//
//import lab1.SeventhTask.SeventhTask;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//public class TestTenthTask {
//    @Test
//    void test1() throws IOException {
//        Runtime runtime = Runtime.getRuntime();
//        runtime.gc();
//
//        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
//        long start = System.nanoTime();
//
//        String answer = TenthTask.findTeam("C:\\Users\\user\\Desktop\\labs\\src\\lab1\\TenthTask\\data_for_first_test");
//
//        long finish = System.nanoTime();
//        double elapsed = (finish - start) / 1_000_000.0;
//
//        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
//        long memoryUsed = memoryAfter - memoryBefore;
//        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);
//
//        System.out.println("Тест 1");
//        System.out.println("Прошло времени в мс: " + elapsed);
//        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
//        System.out.println();
//
//        Assertions.assertEquals("2 4 5", answer);
//        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
//        Assertions.assertTrue(memoryUsedMb < 16, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
//    }
//
//    @Test
//    void test2() throws IOException {
//        Runtime runtime = Runtime.getRuntime();
//        runtime.gc();
//
//        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
//        long start = System.nanoTime();
//
//        String answer = TenthTask.findTeam("C:\\Users\\user\\Desktop\\labs\\src\\lab1\\TenthTask\\data_for_second_test");
//
//        long finish = System.nanoTime();
//        double elapsed = (finish - start) / 1_000_000.0;
//
//        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
//        long memoryUsed = memoryAfter - memoryBefore;
//        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);
//
//        System.out.println("Тест 1");
//        System.out.println("Прошло времени в мс: " + elapsed);
//        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
//        System.out.println();
//
//        Assertions.assertEquals("1 2 3", answer);
//        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
//        Assertions.assertTrue(memoryUsedMb < 16, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
//    }
//
//    @Test
//    void test3() throws IOException {
//        Runtime runtime = Runtime.getRuntime();
//        runtime.gc();
//
//        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
//        long start = System.nanoTime();
//
//        String answer = TenthTask.findTeam("C:\\Users\\user\\Desktop\\labs\\src\\lab1\\TenthTask\\data_for_third_test");
//
//        long finish = System.nanoTime();
//        double elapsed = (finish - start) / 1_000_000.0;
//
//        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
//        long memoryUsed = memoryAfter - memoryBefore;
//        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);
//
//        System.out.println("Тест 1");
//        System.out.println("Прошло времени в мс: " + elapsed);
//        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
//        System.out.println();
//
//        Assertions.assertEquals("1 5 6", answer);
//        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
//        Assertions.assertTrue(memoryUsedMb < 16, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
//    }
//}

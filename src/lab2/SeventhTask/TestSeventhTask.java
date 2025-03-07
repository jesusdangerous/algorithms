package lab2.SeventhTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestSeventhTask {
    @Test
    void test1() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        SeventhTask.getSortedFile("C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\input_first",
                "C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\output_first");

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 1");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        String outputFile = "C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\output_first";
        String expectedFile = "C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\expected_output_first";

        try (BufferedReader outputReader = new BufferedReader(new FileReader(outputFile));
             BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFile))) {

            String outputLine, expectedLine;
            while ((outputLine = outputReader.readLine()) != null &&
                    (expectedLine = expectedReader.readLine()) != null) {
                Assertions.assertEquals(expectedLine, outputLine, "Ошибка: файлы различаются");
            }

            Assertions.assertNull(outputReader.readLine(), "Выходной файл содержит лишние строки");
            Assertions.assertNull(expectedReader.readLine(), "Ожидаемый файл содержит больше строк");
        }

        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 2, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }

    @Test
    void test2() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        SeventhTask.getSortedFile("C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\input_second",
                "C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\output_second");

        long finish = System.nanoTime();
        double elapsed = (finish - start) / 1_000_000.0;

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = memoryAfter - memoryBefore;
        double memoryUsedMb = memoryUsed / (1024.0 * 1024.0);

        System.out.println("Тест 2");
        System.out.println("Прошло времени в мс: " + elapsed);
        System.out.println("Использовано памяти в Мб: " + memoryUsedMb);
        System.out.println();

        String outputFile = "C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\output_second";
        String expectedFile = "C:\\Users\\user\\Desktop\\labs\\src\\lab2\\SeventhTask\\expected_output_second";

        try (BufferedReader outputReader = new BufferedReader(new FileReader(outputFile));
             BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFile))) {

            String outputLine, expectedLine;
            while ((outputLine = outputReader.readLine()) != null &&
                    (expectedLine = expectedReader.readLine()) != null) {
                Assertions.assertEquals(expectedLine, outputLine, "Ошибка: файлы различаются");
            }

            Assertions.assertNull(outputReader.readLine(), "Выходной файл содержит лишние строки");
            Assertions.assertNull(expectedReader.readLine(), "Ожидаемый файл содержит больше строк");
        }

        Assertions.assertTrue(elapsed < 2000, "Метод выполняется слишком долго: " + elapsed + " мс");
        Assertions.assertTrue(memoryUsedMb < 2, "Метод потребляет слишком много памяти: " + memoryUsedMb + " Мб");
    }
}

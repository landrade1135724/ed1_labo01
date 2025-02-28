package ed.lab;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTester<T extends Comparable<T>> {
    private static final int ARRAY_SIZE = 1000;
    private static final int TEST_SIZE = 100;

    public void testSorting(ArrayGenerator<T> generator, QuickSort<T> quickSort) {
        T[] array = generator.generate(ARRAY_SIZE);

        List<Long> durations = new ArrayList<>(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; i++) {
            T[] copy = Arrays.copyOf(array, array.length);

            long start = System.nanoTime(); // ⏱️ Inicio con nanoTime

            quickSort.sort(copy);

            long end = System.nanoTime(); // ⏱️ Fin con nanoTime
            durations.add(end - start);
        }

        // Calcular el promedio en milisegundos
        double average = durations.stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0) / 1_000_000.0; // Convertir a ms

        // Calcular el tiempo total en milisegundos
        double total = durations.stream()
                .mapToLong(Long::longValue)
                .sum() / 1_000_000.0; // Convertir a ms

        System.out.printf("\t\tTiempo promedio: %.3f ms\n", average);
        System.out.printf("\t\tTiempo total: %.3f ms\n", total);
    }
}

//Marc feo